"use strict";

let continuePoint = Math.round(Math.random() * 10);
console.log("continuePointの値: " + continuePoint);
for(let i = 1; i <= 10; i++) {
	console.log(i + "回目のループ開始");
	if(i === continuePoint) {
		console.log("continuePointなのでcontinue");
		continue;
	}
	console.log(i + "回目のループ終了");
}
