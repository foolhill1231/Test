"use strict";

//マウスの出入イベント時の処理関数。
function onMouseInOutEvent(event) {
	//イベント結果表示用リスト要素を取得。
	let msgList = document.getElementById("msgList");
	//イベントが発生した要素のidを取得。
	let targetId = event.target.id;
	//発生したイベントを取得。
	let type = event.type;
	//li要素を生成。
	let item = document.createElement("li");
	//生成したli要素のテキスト部分を作成。
	item.textContent += targetId + "に" + type + "が発生";
	//イベント結果表示用リストに生成したli要素を追加。
	msgList.appendChild(item);
} 

//画面がロードされた時の処理関数。
function init() {
	//外側のdiv要素を取得。
	let outerBox = document.getElementById("outerBox");
	//div要素内をマウスが移動したときの処理。
	outerBox.addEventListener("mousemove", function(event) {
		//内側のp要素を取得。
		let innerBox = document.getElementById("innerBox");
		//内側のp要素にマウスのdiv要素内座標を表示。
		innerBox.textContent = "x=" + event.offsetX + ":y=" + event.offsetY;
	});
	//外側のdiv要素にマウスの出入イベントのリスナ登録。
	outerBox.addEventListener("mouseenter", onMouseInOutEvent);
	outerBox.addEventListener("mouseleave", onMouseInOutEvent);
	outerBox.addEventListener("mouseover", onMouseInOutEvent);
	outerBox.addEventListener("mouseout", onMouseInOutEvent);
}

//［マウス出入イベントの削除］ボタンクリック時の処理関数。
function removeMouseInOutEvent() {
	//外側のdiv要素を取得。
	let outerBox = document.getElementById("outerBox");
	//外側のdiv要素にマウスの出入イベントのリスナ削除。
	outerBox.removeEventListener("mouseenter", onMouseInOutEvent);
	outerBox.removeEventListener("mouseleave", onMouseInOutEvent);
	outerBox.removeEventListener("mouseover", onMouseInOutEvent);
	outerBox.removeEventListener("mouseout", onMouseInOutEvent);
	//イベント結果表示用リスト要素を取得。
	let msgList = document.getElementById("msgList");
	//表示リストを削除。
	msgList.innerHTML = "";
}

//画面がロードされた時の処理をリスナ登録。
window.addEventListener("DOMContentLoaded", init);
