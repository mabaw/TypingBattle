<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Profile</title>
		<link rel="stylesheet" href="/TypingGame/css/main.css"/>
	</head>
	
	<body>
		<div class="head">
			<a href="top.do">return to menu</a>
			|
			<a href="ranking.do?size=30&mode=timelimit&level=easy">view ranking</a>
			|
			<a href="profile.do">view profile</a>
			|
			<a href="logout.do">log out</a> 
			
	</div>
	<div class="main" align="center">
	
			<h1>Profile </h1>
	
		
		<table>
		<tr>
			<td> <img src="image/profile.jpg" width="200" height="200"> </td>
			<td>
					<h2>${player.name},${player.location.name}</h2> <br>
					<h2 class=menubar-select>Top score </h2>
					<table style="width: 300pt">
						<tr>
							<td>
								<img width="100" height="100" src="image/timelimitmode.jpg">
							</td>
							<td style="width: 100pt">
								<img width="100" height="100" src="image/lifemode.jpg">
							</td>
							<td style="width: 100pt">
								<img width="100" height="100" src="image/battlemode.jpg">
							</td>
						</tr>	
						<tr>
							<td>
								1,000 pt
							</td>
							<td style="width: 100pt">
								1,256 pt
							</td>
							<td style="width: 100pt">
								12 pt
							</td>
						</tr>	
							
					</table>
			</td>
		</tr>
		</table>

		<h2 class="menubar-select">Mission clear</h2>
					<table>
						<tr>
							<td style="width: 100pt" ><img src="image/badge.jpg"></td>
							<td style="width: 100pt" ><img src="image/badge.jpg"></td>
							<td style="width: 100pt" ><img src="image/badge.jpg"></td>
						</tr>	
						<tr>
							<td>smart</td>
							<td>beginner</td>
							<td>fast</td>
						</tr>			
					</table>	

<h2 class=menubar-select>This week played</h2>
				<table>
		
		<c:set var="counter" value="0"></c:set>
		<c:forEach var="weekResult" items="${weekResultList}">
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
				<td style="width: 280pt"> ${weekResult.player.name}</td>
				<td style="width: 40pt">  ${weekResult.player.location.name}</td>
				<td style="width: 50pt"> ${weekResult.gameMode.mode} </td>
				<td style="width: 50pt"> ${weekResult.gameMode.level} </td>
				
				
				<td style="width: 100pt"> 
					<c:choose>			
							<c:when test="${weekResult.gameMode.mode=='BATTLE_MODE'}">								
									<c:choose>			
										<c:when test="${weekResult.score==1}">
											 Win
										</c:when>
										<c:when test="${weekResult.score==-1}">
											Lose
										</c:when>
										<c:when test="${weekResult.score==0}">
											Draw
										</c:when>	
									</c:choose>	
							</c:when>				
							<c:otherwise>								
									${weekResult.score} 
							</c:otherwise>
					</c:choose>


				</td>
				
				
			</tr>		
			
		</c:forEach>
	</table>
	
	
	
	</div>
	
	</body>
</html>