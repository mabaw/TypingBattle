<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Register Confirm</title>
			<link rel="stylesheet" href="/TypingGame/css/main.css"/>
	</head>
	
	<body>
	<div class="main" align="center">

	</div>		
	
	<div align="center">	
	Thank you for register with Typing Game
			<table style="width: 300pt">
				<tr>
					<th> Name : </th>
					<td>  ${name}  </td>
				</tr>	
				<tr>
					<th> Upload Photo : </th>
					<td> <img src=" ${photoPath}"></td>
				</tr>		
				<tr>
					<th> Location : </th>
					<td> 
						 ${location.name} 
					</td>
				</tr>	
			    <tr>
					<th> Password : </th>
					<td>  *****  </td>
				</tr>						
			</table>
			
			<a href="login.do">continue to login</a>
	</div>		
					
	</body>
</html>