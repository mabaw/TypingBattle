<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Time Limit Mode</title>
		<link rel="stylesheet" href="css/typing.css"/>
 		<script src="js/jquery.js"></script> 
		<script src="game.js"></script>
	</head>
	
	<body id="all">	
		<div align="center"  class="main">
			<h1> Time Attack Mode</h1>
			<div id="modeArea" align="right">level : ${level}</div>
			<div id="scoreArea" align="right">score : 0</div>
			<div id="timeArea" align="right">time : 0</div>
			<div id="pocaArea" align="right">% : 0</div>

			<img src="image/whale.jpg">
		</div>
		<div id="gameArea" align="center"></div>
	<form name="hidden_form">	
		<input type="hidden" name="level" value="${level}" >
		<input type="hidden" name="playername" value="${playername}" >
	</form>
	</body>
</html>		