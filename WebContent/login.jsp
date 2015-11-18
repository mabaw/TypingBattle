<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Login</title>
			<link rel="stylesheet" href="/TypingGame/css/main.css"/>
	</head>
	
	<body>
	<div class="main" align="center">
	
			<h1>Log in</h1>
			<img src="image/whale.jpg">
	</div>		
	<div align="center">	
	
	<p class="error">${message}</p>
	<form action="login.do" method="post">
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
					<input type="submit" value="log in"> </td>
				</tr>			
			</table>
	</form>		
			<table style="width: 400pt; text-align: right;">	
				<tr>
					<td>not a member ? <a href="register.do">register</a> </td>
				</tr>		
			</table>
			
			
	</div>		
						
			
			<div align=center>
				<a href="index.jsp"> << back </a>
			</div>		
	</body>
</html>