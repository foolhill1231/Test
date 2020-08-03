"use strict";

let num = Math.round(Math.random() * 100);
console.log("現在の値: " + num);
if(num % 2 === 0) {
	console.log("2の倍数です");
	if(num % 3 === 0) {
		console.log("3の倍数です");
	}
} else {
	console.log("2の倍数ではありません");
}
