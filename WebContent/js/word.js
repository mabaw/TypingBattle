$(function() {
			
	const ENTER_KEY = 13; // Enterキー
	var i = 0;
	var flg = 0;
	
	$.getJSON("data/WORD.json", function(data) {
	
		$('#answer').keypress(function(e) {
							
			if(e.which == ENTER_KEY) {
			
				if(data.length == 0) { // 配列の要素数が0であれば終了
					$('#question').text('終了');
					$('#answer').attr('disabled', 'disabled'); // テキストボックスを無効に設定
				}
				
				if(flg == 0) {
				
					$('#answer').val('');
					$('#result').text('');
					
					i = Math.floor(Math.random() * data.length); // 0 ～ 配列の要素数までのランダム値を生成
					
					$('#question').text(data[i].Q);
					
					flg = 1;
					
				} else {
				
					if($('#answer').val() == data[i].A) {
					
						$('#result').css('color', 'black');
						$('#result').text('正解');
						
						data.splice(i, 1);	// 正解した問題を配列から削除
						
					} else {
					
						$('#result').css('color', 'red');
						$('#result').text('不正解 : ' + data[i].A);
					}
					
					flg = 0;
				}
			}
		});
	
	});
		
});