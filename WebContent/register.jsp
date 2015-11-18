<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Register</title>
			<link rel="stylesheet" href="/TypingGame/css/main.css"/>
	</head>
	
	<body>
	
	<div class="main" align="center">
	
			<h1>Register</h1>
			<img src="image/whale.jpg">
	</div>		
	<div align="center" class="error">${message}</div>
	<div align="center">	
	<form action="register.do" method="get"  enctype="multipart/form-data">
			<table style="width: 300pt">
				<tr>
					<th> Name : </th>
					<td> <input type="text" name="name" placeholder="John" required="required" maxlength="20">  </td>
				</tr>	
				<tr>
					<th> Upload Photo : </th>
					<td> <input type="file" name="photo" accept="image/*" >  </td>
				</tr>		
				<tr>
					<th> Location : </th>
					<td> 
							<select name="location">	
								<option disabled="disabled" selected>
									---Select location---
								</option>	
								
								<c:forEach var="location" items="${locationList}">
									<option value="${location.code}">
										${location.code} : ${location.name}
									</option>											

								</c:forEach>								
									
							</select> 		
					</td>
				</tr>	
			    <tr>
					<th> Password : </th>
					<td> <input type="password" name="password" required="required" maxlength="16" >  </td>
				</tr>	
				<tr>
					<th></th>
					<td> 
						<input type="hidden" name="flag" value="${flag}" />
						<input type="reset"> <input type="submit" value="Register">
					</td>
				</tr>			
			</table>
	</form>		
	</div>		
					<div align=center>
				<a href="index.jsp"> << back </a>
			</div>		
	</body>
</html>