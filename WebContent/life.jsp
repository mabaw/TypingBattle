<!DOCTYPE html>

<html lang="ja">

	<head>
		<meta charset="utf-8" />
		<title>Life Mode</title>
	 		<link rel="stylesheet" href="css/typing.css" /> 
		
		<script src="js/jquery.js"></script>
		<script src="life.js"></script>
	</head>
	
 <body id="all"> 
	<div class="main">
		<div id="lifeArea" align="right">
		  	<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			<img src="image/heart.jpg">
			
		</div>
		<div align="center"  class="main">
			<h1> Life Mode</h1>	
		</div>
	</div>
	<div align="center"  class="main">
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
		<div id="gameArea" align="center"></div>
		<div id="submitScoreArea" align="center"></div>
	</body>
</html>