"use strict";

let num = 4;
let rand = Math.round(Math.random() * 10);
console.log("ループ開始");
while(rand !== num) {
	console.log("randの値: " + rand);
	rand = Math.round(Math.random() * 10);
}
console.log("ループ終了");
