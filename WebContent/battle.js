var currentQuestion = 0;
var currentType = -1;
var life = 20;
var opponentLife = 20;
var correct = 0;
var incorrect = 0;
var level = "EASY";

// Battle connection

var Battle = {};
var matchName = "";
var userName = "";
var opponentName = "";

Battle.socket = null;

Battle.connect = (function(host) {
    if ('WebSocket' in window) {
    	Battle.socket = new WebSocket(host);
    } else if ('MozWebSocket' in window) {
    	Battle.socket = new MozWebSocket(host);
    } else {
    	alert("connection error");       
        return;
    }

    Battle.socket.onopen = function () {
        SocketReceiver.log('Info: WebSocket connection opened.');       
    };

    Battle.socket.onclose = function () {        
        SocketReceiver.log('Info: WebSocket closed.');
    };
    
    Battle.sendMessage = (function(message) { 
        	Battle.socket.send(message);        	
    });

    Battle.socket.onmessage = function (message) {    	
        SocketReceiver.log(message.data);
    };
});

Battle.initialize = function(player) {
	alert('ws://' + window.location.host + '/Typing/battle?player=' + player);
    if (window.location.protocol == 'http:') {
        Battle.connect('ws://' + window.location.host + '/Typing/battle?player=' + player);
    } else {
        Battle.connect('wss://' + window.location.host + '/Typing/battle?player=' + player);
    }
};

function joinMatch(host,join){	
	var str = host + ",J," + join; 	
	Battle.sendMessage(str);
}

function attack(power) 
{
	opponentLife -= power;
	var attackStr = matchName + ",A," + power + "," + opponentName; 
	Battle.sendMessage(attackStr);
	drawOpponentLife();
}

var SocketReceiver = {};

SocketReceiver.log = (function(message) {
	 var msg_hostName = "";
	 var splitMessage = message.split(",");
	 msg_hostName = splitMessage[0];	 
	 if(msg_hostName == matchName)
		 {				
		 	var actionStr = "";
		 	actionStr = splitMessage[1];
		 	if(actionStr[0]=='U') // update score
		 	{		 			
		 			var msg_hostLife = splitMessage[2];
		 			var msg_joinedLife = splitMessage[3];
				 	if(matchName == userName) // is a host
				 	{
				 		opponentLife = msg_joinedLife;
				 		life = msg_hostLife;
				 	}
				 	else{
				 		opponentLife = msg_hostLife;
				 		life = msg_joinedLife;
				 	} 		
				 	drawLife();
				 	drawOpponentLife();
				 	attackedWhale();
				 	
		 	}
			if(actionStr[0]=='J') // joined user come in
			{							
				var joinedName =  splitMessage[2];
				opponentName = joinedName;				
				document.getElementById("opponentNameArea").innerHTML = joinedName;				
				loadQuestion();
			}
			if(actionStr[0]=='E') // game end
			{				
				var winner =  splitMessage[2];
				var score = 0;
				if(winner == userName){
					document.getElementById("opponentNameArea").innerHTML = "<h2>....You Win!!!....</h2>";
					score = 1;
				}
				else if(winner == opponentName){
					document.getElementById("opponentNameArea").innerHTML = "<h2>....You Lose....</h2>";
					score = -1;
				}
				else
				{
					document.getElementById("opponentNameArea").innerHTML = "<h2>....Draw....</h2>";
					score = 0;
				}
				sendResult(score,level,incorrect,correct);
			}
		 }
	 else {
		 //ignore other room
	 }
	
});

function sendResult(score,level,incorrect,correct)
{
	window.location = "http://" + window.location.host + "/TypingGame/game.do?" + "score="+score+"&mode=BATTLE_MODE&level="+level+"&incorrect="+incorrect+"&correct="+correct+"&flag=timeover";
	
}

function attackedWhale(){	
		document.getElementById("gameArea").innerHTML = "<font color=red>ATTACK!! </font>";			
}

function updateWhale(){
	if(opponentLife<=5)
		document.getElementById("whaleArea").innerHTML = "<img src='image/sadWhale.jpg'>";
	else
		document.getElementById("whaleArea").innerHTML = "<img src='image/whale.jpg'>";
}



//// END : Battle connection

function drawOpponentLife(){

	var liftStr="";
	for(var i=1;i<=opponentLife;i++)
	{
		liftStr += "<img src='image/heart.jpg'>";
	}
	document.getElementById("opponentArea").innerHTML = liftStr;

}

// Game Engine 


function drawLife(){

	var liftStr="";
	for(var i=1;i<=life;i++)
	{
		liftStr += "<img src='image/heart.jpg'>";
	}
	document.getElementById("lifeArea").innerHTML = liftStr;

}

function drawQuestion(curKeyPress,word,textColor){
	var questionStr = "";
	for(var i=0;i<word.length;i++){
		var u = "";
		if(i==curKeyPress+1) {
			u = ' style="text-decoration: underline;" ';
		}
		questionStr += "<FONT COLOR=" + textColor[i] + u +">" + word[i] + "</FONT>";	
	}
	 document.getElementById("gameArea").innerHTML = questionStr;
}


function loadQuestion()
{
	$.getJSON("questionfile/question_"+ matchName +".JSON", function(data) {
			var curQuestion = 0;
			var curKeyPress = -1;
			var mistake = 0;
			var textColor = new Array();			
			for(var i=0;i<data[curQuestion].Q.length;i++){
					textColor[i] = "black";
				}
				 drawQuestion(curKeyPress,data[curQuestion].Q,textColor);

				$('#all').keypress(function(e) {
					curKeyPress++;					
					var kc = e.which; 
					if(String.fromCharCode(kc)==data[curQuestion].Q[curKeyPress])
					{	
						textColor[curKeyPress] = "grey";			
						correct++;
					}
					else
					{
						textColor[curKeyPress] = "red";
						mistake++;
						incorrect++;
					}	
					
					drawQuestion(curKeyPress,data[curQuestion].Q,textColor);
				
					if(curKeyPress==data[curQuestion].Q.length-1)
					{
						if(mistake < 10)
							{
								if(mistake==0)
								{
									attack("5");
								}
								else if(mistake<6)
								{
									attack("2");
								}
								else
								{
									attack("1");
								}
							}
						updateWhale();
						mistake = 0;
						curQuestion++;
						if(curQuestion==data.length)
							curQuestion=0;
						curKeyPress = -1;	
						for(var i=0;i<data[curQuestion].Q.length;i++)
							textColor[i] = "black";		
						
						 drawQuestion(curKeyPress,data[curQuestion].Q,textColor);
					}				
			});	
	
	});
}

function gameInit(host,join){	
	matchName = host;
	if(join!="")
		Battle.initialize(join);
	else 
		Battle.initialize(host);
	
	if(join!="" && host != join) // start immediately if join a battle
	{
		userName = join;	
		opponentName = host;
		document.getElementById("opponentNameArea").innerHTML = opponentName;
		
		// broadcast to host
		setTimeout(function(){joinMatch(host,join);},3000);
		setTimeout(function(){loadQuestion();},3000);	
		
	}
	else{
		userName=host;
		document.getElementById("opponentNameArea").innerHTML = "Waiting for opponent to join";
	}
}