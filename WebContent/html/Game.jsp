<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Great Number Game</title>
<style type="text/css">
body {
	margin: auto;
	width: 50%
}

header {
	text-align: center;
}

div#message {
	width: 300px;
	height: 300px;
	display: block;
	margin: auto;
}

#message.hidden,input.hidden {
    display: none;
}

.success {
	background-color: green;
}

.failure {
	background-color: red;
}

#message h2 {
	line-height: 300px;
	text-align: center;
	color: white;
	font-weight: bold;
	font-size:xx-large;
}

form, input, button {
	margin: auto;
	margin-top: 1em;
	display: block;
}
</style>
</head>
<body>
    <header>
		<h1>Welcome to the Great Number Game!</h1>
		<p>I am thinking of a number between 1 and 100</p>
		<p>Take a guess!</p>
	</header>

	<div id="message" class=<%= request.getAttribute("msgClass") %>>
		<h2><%= request.getAttribute("message") %></h2>
	</div>
	
	<form action="Game" method="post">
		<input id="input" class=<%= request.getAttribute("inputClass")%> type="text" id="guess" name="guess" autofocus/>
		<button type="submit"><%= request.getAttribute("buttonLabel")%></button>
	</form>
</body>
</html>

