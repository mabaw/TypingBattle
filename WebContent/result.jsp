<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Result</title>
			<link rel="stylesheet" href="/TypingGame/css/main.css"/>
	</head>
	
	<body>
	
	
	<div class="head">
			<a href="top.do">return to menu</a>
			|
			<a href="ranking.do?size=30&mode=${mode}&level=${level}">view ranking</a>
			|
			<a href="profile.do">view profile</a>
			|
			<a href="logout.do">log out</a> 
			
	</div>
	
	<div class="main" align="center">
	
			<h1>nice game :) </h1>
			<img src="image/whale.jpg">
	
	<div>
			<p> Your typing result </p>
	<table>
	
		<tr>
			<th> Mode : </th>
			<td> ${mode} </td>
		</tr>
		
		<tr>
			<th> level : </th>
			<td> ${level} </td>
		</tr>
		
		<c:choose>			
				<c:when test="${mode=='BATTLE_MODE'}">
					<tr>
						<th> Result : </th>
						<c:choose>			
							<c:when test="${score==1}">
								<td> Win</td>
							</c:when>
							<c:when test="${score==-1}">
								<td> Lose </td>
							</c:when>
							<c:when test="${score==0}">
								<td> Draw </td>
							</c:when>	
						</c:choose>					
					</tr>
				</c:when>				
				<c:otherwise>
					<tr>
						<th> Score : </th>
						<td> ${score} </td>
					</tr>
				</c:otherwise>
		</c:choose>
		
		
		<tr>
			<th> Correctness : </th>
			<td> ${correctness} %</td>
		</tr>
	</table>
	
	
	</div>
	</div>		
	</body>
</html>