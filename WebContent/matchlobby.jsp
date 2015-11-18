<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Battle Match Lobby</title>
	    <link rel="stylesheet" href="/TypingGame/css/main.css"/>
	</head>
	
	<body>
		<div class="main"  align="center">
		<div class="head">
			<a href="top.do">return to menu</a>
			|
			<a href="ranking.do?size=30&mode=timelimit&level=easy">view ranking</a>
			|
			<a href="profile.do">view profile</a>
			|
			<a href="logout.do">log out</a> 
			
	</div>
		
		<h1>Join a match</h1>
		<table>
		
			<tr style="width: 500pt;"" bgcolor="#C6DEFF">
				<td style="width: 400pt">Match host</td>
				<td style="width: 100pt">level</td>
			</tr>
				<c:forEach var="match" items="${matchList}">			
					<tr style="width: 500pt" >		
						<td style="width: 400pt"><a href="battle.do?action=join&name=${match.hostPlayer.name}"> ${match.hostPlayer.name}</a></td>
						<td style="width: 100pt">  ${match.level}</td>
					</tr>		
			
				</c:forEach>
		</table>
		<form action="battle.do" method="post">
		<table>
		
			<tr style="width: 500pt">
				<td style="width: 500pt"><div  align="right">
				choose level :
				<select name="level">
					<option value="easy">easy</option>
					<option value="normal">normal</option>
					<option value="difficult">difficult</option>
				</select>
				<input type="hidden" name="action" value="create">
				<input type="submit" value="Create a match"> </div></td>				
			</tr>			
		</table>
		</form>
		
		
		
		
		
		</div>
	</body>
</html>