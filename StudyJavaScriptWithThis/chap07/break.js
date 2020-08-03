"use strict";

let breakPoint = Math.round(Math.random() * 10);
console.log("breakPointの値: " + breakPoint);
for(let i = 1; i <= 10; i++) {
	console.log(i + "回目のループ開始");
	if(i === breakPoint) {
		console.log("breakPointなのでbreak");
		break;
	}
	console.log(i + "回目のループ終了");
}
