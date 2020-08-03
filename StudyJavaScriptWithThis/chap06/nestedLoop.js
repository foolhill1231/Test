"use strict";

console.log("外のループ開始");
for(let i = 1; i <= 3; i++) {
	console.log("内のループ開始");
	for(let j = 1; j <= 3; j++) {
		console.log("i:j=" + i + ":" + j);
	}
	console.log("内のループ終了");
}
console.log("外のループ終了");
