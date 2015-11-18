<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Top</title>
			<link rel="stylesheet" href="/TypingGame/css/main.css"/>
			
			<script type="text/javascript">
			
			function changelevel(selectobj){
				window.location = "http://" + window.location.host + "/TypingGame/top.do?level="+selectobj.value; 
			}
			
			</script>
	</head>
	
	<body>
	
	<div class="head">
			<b>top</b>
			|
			<a href="ranking.do?size=30&mode=timelimit&level=easy">view ranking</a>
			|
			<a href="profile.do">view profile</a> 
			|
			<a href="logout.do">log out</a> 

	</div>
	
	<div class="main" align="center">

	
	
			<h1>Choose mode</h1>
	</div>		
	<div align="center">	
	<form action="login.do" method="get">
			<table>
				<tr>
					<td style="width: 100pt"><a href="game.do?mode=timelimit&level=${level}"><img width="150" height="150" src="image/timelimitmode.jpg"></a></td>
					<td style="width: 100pt"><a href="game.do?mode=life&level=${level}"><img width="150" height="150" src="image/lifemode.jpg"></a></td>
					<td style="width: 100pt"><a href="battle.do"><img width="150" height="150" src="image/battlemode.jpg"></a></td>
				</tr>	
				<tr class="menubar">
					<td>Time limit</td>
					<td>Life</td>
					<td>Battle</td>
				</tr>			
			</table>
			<p>
							Level setting : 
							<select id="selectlevel"  onChange="changelevel(this)">
							
							
								<option disabled="disabled">
									---please select level---
								</option>		
								<c:choose>			
									<c:when test="${level=='easy'}">
										<option value="easy"  selected="selected"> easy </option>					
									</c:when>
									<c:otherwise>
										<option value="easy"> easy </option>
									</c:otherwise>
								</c:choose>
			
								<c:choose>			
									<c:when test="${level=='normal'}">
										<option value="normal"  selected="selected"> normal </option>					
									</c:when>
									<c:otherwise>
										<option value="normal"> normal </option>
									</c:otherwise>
								</c:choose>
								
								<c:choose>			
									<c:when test="${level=='difficult'}">
										<option value="difficult"  selected="selected"> difficult </option>					
									</c:when>
									<c:otherwise>
										<option value="difficult"> difficult </option>
									</c:otherwise>
								</c:choose>
			
							</select>							
			</p>
	</form>		
	</div>		
	<div align="right"><a href="delete.do">delete account</a></div>					
					
	</body>
</html>