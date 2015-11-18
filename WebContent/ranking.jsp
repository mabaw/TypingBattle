<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Ranking</title>
		<link rel="stylesheet" href="/TypingGame/css/main.css"/>
	</head>
	
	<body>
	<div class="head">
			<a href="top.do">return to menu</a>
			|
			<b>view ranking</b>
			|
			<a href="profile.do">view profile</a>
			|
			<a href="logout.do">log out</a> 
			
	</div>
	
	
	<div class="main" align="center">
	
			<h1>Worldwide Ranking </h1>
			<img src="image/world.jpg" width="270" height="250">
	
	<form action="ranking.do">
		<select name="mode">
			<c:choose>			
				<c:when test="${mode=='timelimit'||mode=='TIME_LIMIT_MODE'}">
					<option value="timelimit"  selected="selected"> Time limit </option>
				</c:when>
				<c:otherwise>
					<option value="timelimit"> Time limit </option>
				</c:otherwise>
			</c:choose>
			
			<c:choose>			
				<c:when test="${mode=='life'||mode=='LIFE_MODE'}">
					<option value="life" selected="selected"> Life </option>
				</c:when>
				<c:otherwise>
					<option value="life"> Life </option>
				</c:otherwise>
			</c:choose>
			
			<c:choose>			
				<c:when test="${mode=='battle'||mode=='BATTLE_MODE'}">
					<option value="battle"  selected="selected"> Battle </option>
				</c:when>
				<c:otherwise>
					<option value="battle"> Battle </option>
				</c:otherwise>
			</c:choose>
			
		</select>
		<select name="level">
			<c:choose>			
				<c:when test="${level=='easy'||level=='EASY'}">
					<option value="easy"  selected="selected"> easy </option>					
				</c:when>
				<c:otherwise>
					<option value="easy"> easy </option>
				</c:otherwise>
			</c:choose>
			
			<c:choose>			
				<c:when test="${level=='normal'||level=='NORMAL'}">
					<option value="normal"  selected="selected"> normal </option>					
				</c:when>
				<c:otherwise>
					<option value="normal"> normal </option>
				</c:otherwise>
			</c:choose>
			
			<c:choose>			
				<c:when test="${level=='difficult'||level=='DIFFICULT'}">
					<option value="difficult"  selected="selected"> difficult </option>					
				</c:when>
				<c:otherwise>
					<option value="difficult"> difficult </option>
				</c:otherwise>
			</c:choose>
			
		</select>
		<input type="hidden" name="size" value="30">
		<input type="submit" value="change">
	</form>

	<table>
		<tr  style="width: 600pt">
			<td style="width: 300pt"></td>
			<c:choose>			
				<c:when test="${mode=='timelimit'||mode=='TIME_LIMIT_MODE'}">
					<td style="width: 100pt" class="menubar-select">Time limit Mode</td>
				</c:when>
				<c:otherwise>
					<td style="width: 100pt" class="menubar">Time limit Mode</td>
				</c:otherwise>
			</c:choose>
			
			<c:choose>			
				<c:when test="${mode=='life'||mode=='LIFE_MODE'}">
					<td style="width: 100pt" class="menubar-select">Life Mode</td>
				</c:when>
				<c:otherwise>
					<td style="width: 100pt" class="menubar">Life Mode</td>
				</c:otherwise>
			</c:choose>
			
			<c:choose>			
				<c:when test="${mode=='battle'||mode=='BATTLE_MODE'}">
					<td style="width: 100pt" class="menubar-select">Battle Mode</td>
				</c:when>
				<c:otherwise>
					<td style="width: 100pt" class="menubar">Battle Mode</td>
				</c:otherwise>
			</c:choose>
			
			
		</tr>		
	</table>
		<table>
		
		<c:set var="counter" value="0"></c:set>
		<c:forEach var="result" items="${resultList}">
			<c:set var="counter" value="${counter+1}"></c:set>
			<c:choose>			
				<c:when test="${(counter%2)==0}">
					<tr  style="width: 600pt">
				</c:when>
				<c:otherwise>
					<tr  style="width: 600pt" bgcolor="#C6DEFF">
				</c:otherwise>
			</c:choose>
				<th style="width: 20pt"> ${counter}</th>
				<td style="width: 60pt"><img src="image/smallprofile.jpg"></td>
				<td style="width: 380pt"> ${result.player.name}</td>
				<td style="width: 40pt">  ${result.player.location.name}</td>
				<td style="width: 100pt">
					<c:choose>			
							<c:when test="${result.mode==3}">								
									<c:choose>			
										<c:when test="${result.score==1}">
											 Win
										</c:when>
										<c:when test="${result.score==-1}">
											Lose
										</c:when>
										<c:when test="${result.score==0}">
											Draw
										</c:when>	
									</c:choose>	
							</c:when>				
							<c:otherwise>								
									${result.score} 
							</c:otherwise>
					</c:choose>
				</td>
			</tr>		
			
		</c:forEach>
	</table>
	
	
	<p>	<a href="top.do">return to menu</a> </p>
	
	
	</div>
	
	</body>
</html>