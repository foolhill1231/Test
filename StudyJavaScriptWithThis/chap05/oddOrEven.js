"use strict";

let num = Math.round(Math.random() * 100);
console.log("現在の値: " + num);
let rem = num % 2;
if(rem == 0) {
	console.log("数値は偶数です");
} else {
	console.log("数値は奇数です");
}
