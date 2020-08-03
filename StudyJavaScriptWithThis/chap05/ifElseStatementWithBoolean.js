"use strict";

let num = Math.round(Math.random() * 100);
console.log("現在の値: " + num);
let cond = (num <= 40);
if(cond) {
	console.log("数値は40以下です");
} else {
	console.log("数値は40より大きいです");
}
console.log("処理終了!");
