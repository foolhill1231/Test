"use strict";

//画面がロードされた時の処理をリスナ登録。
window.addEventListener("DOMContentLoaded", function() {
	//入力エリア要素を取得。
	let messageArea = document.getElementById("messageArea");
	//入力エリアにinputリスナ登録。
	messageArea.addEventListener("input", function() {
		//入力された内容を取得。
		let message = messageArea.value;
		//入力された文字数を取得。
		let msgLength = message.length;
		//文字数表示要素を取得。
		let showMessageLength = document.getElementById("showMessageLength");
		//文字数を表示。
		showMessageLength.textContent = msgLength + "/70";
		//文字数が70を超えたら背景を赤に。それ以外は元通りに。
		if(msgLength > 70) {
			messageArea.classList.add("alertBg");
		} else {
			messageArea.classList.remove("alertBg");
		}
	});
});
