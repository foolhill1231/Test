"use strict";

//［入力値の表示］ボタンクリック時の処理。
function onFreewordButtonClick() {
	//idがfreewordInputのinput要素を取得。
	let freewordInput = document.getElementById("freewordInput");
	//取得したinput要素の入力値を取得。
	let freewordInputValue = freewordInput.value;
	//取得したinput要素のname属性値を取得。
	let freewordInputName = freewordInput.getAttribute("name");
	//idがshowInputのp要素を取得。
	let showInput = document.getElementById("showInput");
	//取得したp要素のテキストにinput要素の入力値とname属性を表示。
	showInput.textContent = "name属性が" + freewordInputName + "の入力された値: " + freewordInputValue;
}
