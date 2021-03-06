<!DOCTYPE html>
<?php require_once('DataBaseLogin.php'); ?>
<html>
<head>
    <title>Page Title</title>
</head>

<body>
<h3>
Query 1: Get a list of the teams
<form method="post" action="queries.php/?query=1" target="_blank">
	<input type="submit" value="Get team names">
</form> 
</h3>

<br><br>

<h3>
Query 2: Get the team a player played for in a specific year
<form method="post" action="queries.php/?query=2" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input id="year" name="year" value="" type="text" autocomplete="on" placeholder="Year">
	<input type="submit" value="What team did they play for?">
</form> 
</h3>

<br><br>

<h3>
Query 3: Get basic player information
<form method="post" action="queries.php/?query=3" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input type="submit" value="Get basic player information...">
</form> 
</h3>

<br><br>

<h3>
Query 4: Get batting statistics for a player during a specific year
<form method="post" action="queries.php/?query=4" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input id="year" name="year" value="" type="text" autocomplete="on" placeholder="Year">
	<input type="submit" value="How did they do?">
</form> 
</h3>

<br><br>

<h3>
Query 5: Get pitching statistics for a player during a specific year
<form method="post" action="queries.php/?query=5" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input id="year" name="year" value="" type="text" autocomplete="on" placeholder="Year">
	<input type="submit" value="How did they do?">
</form> 
</h3>

<br><br>

<h3>
Query 6: Get fielding statistics for a player during a specific year
<form method="post" action="queries.php/?query=6" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input id="year" name="year" value="" type="text" autocomplete="on" placeholder="Year">
	<input type="submit" value="How did they do?">
</form> 
</h3>

<br><br>

<h3>
Query 7: Get manager for given team during a specific year
<form method="post" action="queries.php/?query=7" target="_blank">
	<input id="teamName" name="teamName" value="" type="text" autocomplete="on" placeholder="Team Name">
	<input id="year" name="year" value="" type="text" autocomplete="on" placeholder="Year">
	<input type="submit" value="Get manager">
</form> 
</h3>

<br><br>

<h3>
Query 8: Get salary for a given person during a specific year
<form method="post" action="queries.php/?query=8" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input id="year" name="year" value="" type="text" autocomplete="on" placeholder="Year">
	<input type="submit" value="Get salary">
</form> 
</h3>

<br><br>

<h3>
Query 9: Get the school that a given person played for
<form method="post" action="queries.php/?query=9" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input type="submit" value="Get school">
</form> 
</h3>

<br><br>

<h3>
Query 10: Get the awards given during a specific year
<form method="post" action="queries.php/?query=10" target="_blank">
	<input id="year" name="year" value="" type="text" autocomplete="on" placeholder="Year">
	<input type="submit" value="Get awards">
</form> 
</h3>

<br><br>

<h3>
Query 11: Get the awards given to a specific player
<form method="post" action="queries.php/?query=11" target="_blank">
	<input id="firstName" name="firstName" value="" type="text" autocomplete="on" placeholder="First Name">
	<input id="lastName" name="lastName" value="" type="text" autocomplete="on" placeholder="Last Name">
	<input type="submit" value="Get awards">
</form> 
</h3>

<br><br>

<h3>
Query 12: Get the players a specific award has been given to
<form method="post" action="queries.php/?query=12" target="_blank">
	<input id="awardID" name="awardID" value="" type="text" autocomplete="on" placeholder="Award Name">
	<input type="submit" value="Get players">
</form> 
</h3>

</body>
</html>
