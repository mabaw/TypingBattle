<!DOCTYPE html>

<html lang="ja">

	<head>
		<meta charset="utf-8" />
		<title>Battle Mode</title>
	 		<link rel="stylesheet" href="css/typing.css" /> 
		
		<script src="js/jquery.js"></script>
	<!-- 	<script src="js/word.js"></script> -->
		
		<script src="battle.js"></script>
	</head>
	
<!-- <body onload="loadQuestion()" id="all">  -->
 <body onload="gameInit('${host}','${join}')" id="all">	
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
			<h1> Battle Mode</h1>
			<div id="opponentNameArea"></div>
			<div id="whaleArea"><img src="image/whale.jpg">	</div>			
			<div id="opponentArea" align="center">
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

			</div>
		<div id="gameArea" align="center"></div>
		<div id="submitScoreArea" align="center"></div>
	</div>	
		
		
		

		
	</body>
</html>