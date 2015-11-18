<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Delete Account</title>
		<link rel="stylesheet" href="/TypingGame/css/main.css" />
	</head>
	<body>
		<body>
	<div class="main" align="center">
	
			<h1>Delete Account</h1>
	</div>		
	<div align="center">	
	
	<p>${message}</p>
	<form action="delete.do" method="post">
			<table style="width: 300pt">
				<tr>
					<th> Name : </th>
					<td> <input type="text" name="name" placeholder="John" required="required">  </td>
				</tr>	
				<tr>
					<th> Password : </th>
					<td> <input type="password" name="password"  required="required">  </td>
				</tr>			
				<tr>
					<th></th>
					<td>
					<input type="hidden" name="flag" value="${flag}" />
					<input type="submit" value="Delete"> </td>
				</tr>			
			</table>
	</form>		
			<table style="width: 400pt; text-align: right;">	
			</table>
			
			
	</div>		
						
			
			<div align=center>
				<a href="top.jsp"> << back to top </a>
			</div>		
	</body>
</html>