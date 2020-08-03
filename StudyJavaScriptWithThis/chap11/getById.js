"use strict";

//［h1要素の取得］ボタンクリック時の処理。
function onH1ButtonClick() {
	//idがheadTitleの要素を取得。
	let headTitle = document.getElementById("headTitle");
	//取得した要素をコンソール表示。
	console.log(headTitle);
}

//［h1のテキスト取得］ボタンクリック時の処理。
function onH1TextButtonClick() {
	//idがheadTitleの要素を取得。
	let headTitle = document.getElementById("headTitle");
	//取得した要素のテキスト部分を取得。
	let headTitleText = headTitle.textContent;
	//取得したテキスト部分をコンソール表示。
	console.log(headTitleText);
}

//［h1のテキスト書換］ボタンクリック時の処理。
function onH1TextAltButtonClick() {
	//idがheadTitleの要素を取得。
	let headTitle = document.getElementById("headTitle");
	//取得した要素のテキスト部分を変更。
	headTitle.textContent = "idによる取得サンプル";
}
