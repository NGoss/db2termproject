import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;



public class HTTPConnection
{
	//store IP address of server
	private String host = "localhost";
	//Hold the HTTP connection
	private HttpURLConnection connection;
	//Query results
	ArrayList<String> resultList = new ArrayList<>();
	//Current user credentials
	private String userName;
	private String password;
	
	public HTTPConnection()
	{
	}
	
	/**Set the IP of the server you are connecting to**/
	public void setHost(String host)
	{
		this.host = host;
	}
	
	/** executes query on server, only pass the arguments you need 
	 * Returns Arraylist containing each result set
	 * **/
	public ArrayList<String> executeQuery(int query, String firstname, String lastname, String year, String teamname, String awardID) throws Exception
	{
		URL url = new URL("http://" + host + "/queries.php" + "/?query=" + query);
		connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());

		//Credentials for logging into the database
		String loginCredentials = "username=" + userName + "&password=" + password;
		
		//Determine which query the user selected and send relevant information to the server
		switch (query)
		{
		case 1:
			outputStream.writeBytes(loginCredentials);
			break;
		case 2:
			outputStream.writeBytes(loginCredentials + "&firstName=" + firstname + "&lastName=" + lastname + "&year=" + year);
			break;
		case 3:
			outputStream.writeBytes(loginCredentials + "&firstName=" + firstname + "&lastName=" + lastname);
			break;
		case 4:		
		case 5:	
		case 6:
			outputStream.writeBytes(loginCredentials + "&firstName=" + firstname + "&lastName=" + lastname + "&year=" + year);
			break;
		case 7:
			outputStream.writeBytes(loginCredentials + "&teamName=" + teamname + "&year=" + lastname);
			break;
		case 8:
			outputStream.writeBytes(loginCredentials + "&firstName=" + firstname + "&lastName=" + lastname + "&year=" + year);
			break;
		case 9:
			outputStream.writeBytes(loginCredentials + "&firstName=" + firstname + "&lastName=" + lastname);
			break;
		case 10:
			outputStream.writeBytes(loginCredentials + "&year=" + year);
			break;
		case 11:
			outputStream.writeBytes(loginCredentials + "&firstName=" + firstname + "&lastName=" + lastname);
			break;
		case 12:
			outputStream.writeBytes(loginCredentials + "&awardID=" + awardID);
			break;
		default:
			break;
		}
			
		outputStream.flush();
		outputStream.close();
		
		int code = connection.getResponseCode();
		
		//If the request was successful read the query results from the server
		if(code == 200)
		{
			resultList.clear();
			//read retrieve results from database
			readResultsFromServer();
		}
		
		connection.disconnect();
		return resultList;
	}
	
	/**Params userName, password for logging into the database
	 * Returns response code from server
	 * **/
	public int loginToServer(String userName, String password) throws Exception
	{
		URL url = new URL("http://" + host + "/DataBaseLogin.php");
		connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
		//Send login credentials
		outputStream.writeBytes("username=" + userName + "&password=" + password);
		outputStream.flush();
		outputStream.close();
		
		int code = connection.getResponseCode();
		
		//System.out.println(new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine());
		
		connection.disconnect();
		
		//Save user session
		this.userName = userName;
		this.password = password;
		
		return code;
	}
	
	/**
	 * Close current users session on server
	 * Returns response code from server
	 * **/
	public int logoutFromServer() throws Exception
	{
		URL url = new URL("http://" + host + "/DataBaseLogout.php");
		connection = (HttpURLConnection) url.openConnection();
		//Any method can be used here logout uses no client information
		connection.setRequestMethod("GET");
		
		int code = connection.getResponseCode();
		connection.disconnect();
		//remove user session
		this.userName = "";
		this.password = "";
		
		return code;
	}
	
	private void readResultsFromServer() throws IOException
	{
		StringBuilder results = new StringBuilder();
		BufferedReader inputStreamBufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		int index = 0;
		
		//Get response from server
		while ((line = inputStreamBufferedReader.readLine()) != null)
		{
			results.append(line);				
		}
		inputStreamBufferedReader.close();

		//Parse response and remove extra data
		index = results.indexOf("<br>", results.indexOf("<br>") + 1);
		results.delete(0, index + 4);
		
		//place each result into arraylist index
		while((index = results.indexOf("<br>")) != -1)
		{
			resultList.add(results.substring(0, index - 1).trim());
			results.delete(0, index + 4);
		}
	}
}