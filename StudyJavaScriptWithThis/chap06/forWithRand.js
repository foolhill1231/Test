"use strict";

let num = 4;
console.log("ループ開始");
for(let rand = Math.round(Math.random() * 10); rand !== num; rand = Math.round(Math.random() * 10)) {
	console.log("randの値: " + rand);
}
console.log("ループ終了");
