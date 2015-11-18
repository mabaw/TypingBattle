/*
 * グローバル変数の定義
 */
var curQuestion = 0;			//今答えるべき問題の添え字
var curKeyPress = -1;			//今答えるべきキーの添え字
var textColor 	= new Array();	//問題の１文字の表示色
var score 		= 0;			//スコア（一文字正解すると＋２点、間違うとー１点）
var u 			= "";			//次に答えるべき一文字にアンダーライン属性をセットする
var questionStr = "";			//問題文の文字をすべて<font>タグで一文字に区切って格納する
var incorrect = 0;
var correct = 0;
var poca;				//Percentage of correct answer.正答率
var startTime;			//開始時の時刻を格納
var nowTime;  			//現在の時刻を格納（最終的には、終了時の時刻を格納）
var timer;
var playername;
/*
 *  経過時間をdiv領域に表示する動作を一定間隔で繰り返す
 */
function TimeLapsedView(){
  document.getElementById("timeArea").innerHTML = "Time:"+TimeLapsed();
  timer = setTimeout("TimeLapsedView()",50);
}
/*
 * 
 */
function TimeLapsed(){
	nowTime = new Date();

	var datet = parseInt((nowTime.getTime() - startTime.getTime()) / 1000);

	var hour = parseInt(datet / 3600);
	var min = parseInt((datet / 60) % 60);
	var sec = datet % 60;

	// 数値が1桁の場合、頭に0を付けて2桁で表示する指定
	if(hour < 10) {
		hour = "0" + hour;
	}
	if(min < 10) {
		min = "0" + min;
	}
	if(sec < 10) {
		sec = "0" + sec;
	}
	var nowTimeStr = hour+":"+min+":"+sec;
	return nowTimeStr;
}
/*
 * ページが読み込まれたときのイベント関数
 */
jQuery(function(){
	
	startTime = new Date();	
	TimeLapsedView();	
	/*
	 * JSONファイルを読み込んだときのイベント関数
	 */
	playername = document.hidden_form.playername.value;
	$.getJSON("questionfile/question_"+playername+".JSON", function(data) {	

		//一問目の文字について、表示色を配列に設定する
		for(var i=0;i<data[curQuestion].Q.length;i++){
			textColor[i] = "black";
		}
		//出題する
		 drawQuestion(curKeyPress,data[curQuestion].Q,textColor);
		
		/*
		 * キーが押されたときのイベント関数
		 */
		$('#all').keypress(function(e) {
		curKeyPress++;	
							
			//入力キーが正解
			if(String.fromCharCode(e.which)==data[curQuestion].Q[curKeyPress]){
				//表示色をグレーに変える
				textColor[curKeyPress] = "grey";			
				//加点する
				score += 2;
				correct++;

			//入力キーが不正解
			}else{
				//表示色を赤に変える
				textColor[curKeyPress] = "red";
				//減点する
				score -= 1;
				incorrect++;
			}
			//正当率の計算・表示
			putPoca();
			//スコアエリアに、スコアを表示
			document.getElementById("scoreArea").innerHTML = "Score : " + score;
			
			//出題する
			drawQuestion(curKeyPress,data[curQuestion].Q,textColor);
			
			//その問題の最後の１文字だったら、次の問題に移る準備をする
			if(curKeyPress>=data[curQuestion].Q.length-1){
				curQuestion++;
				//問題集の最後の問題だったら、出題を終える
				if(curQuestion>=data.length){
					curQuestion=0;
					data.splice(curQuestion, data.length);

					//終了処理
  					document.getElementById("gameArea").innerHTML = "Clear!";
  					// タイマーのクリア
  					clearInterval( timer );
  					
  					var levelStr= document.hidden_form.level.value;
					sendResult(score,levelStr,incorrect,correct);
				}
				//打つべきキーを示す添え字を、次の問題の先頭へ移す
				curKeyPress = -1;
				
				//次の問題の文字について、表示色を配列に設定する
				for(var i=0;i<data[curQuestion].Q.length;i++){
					textColor[i] = "black";		
				}
				//出題する
				drawQuestion(curKeyPress,data[curQuestion].Q,textColor);
				
			}
		});	
			
	});
		
});
function putPoca(){
	poca=correct/(correct+incorrect)*100;
	poca=poca.toFixed(3);
	document.getElementById("pocaArea").innerHTML = "% : " + poca;
}

/*
 * １問出題する関数
 * 引数：押すべきキーの添え字、次に出題する問題文字列、次に出題する問題の表示色を示す配列
 */
function drawQuestion(curKeyPress,word,textColor){

	questionStr = "";
	//問題文の最後の文字まで繰り返す
	for(var i=0;i<word.length;i++){
		u = "";
		//次の答えるべき問題に、アンダーラインを属性にセット
		if(i==curKeyPress+1){
			u = ' style="text-decoration: underline;" ';
		}
		//問題文の文字をすべて<font>タグで一文字に区切って、追加する
		questionStr += "<FONT COLOR=" + textColor[i] + u +">" + word[i] + "</FONT>";	
	}
	 document.getElementById("gameArea").innerHTML = questionStr;
}

function sendResult(score,level,incorrect,correct){
	window.location = "http://" + window.location.host + "/TypingGame/game.do?" + "score="+score+"&mode=TIME_LIMIT_MODE&level="+level+"&incorrect="+incorrect+"&correct="+correct+"&flag=timeover";
}