"use strict";

let num = Math.round(Math.random() * 100);
console.log("現在の値: " + num);
if((num % 2 === 0) && (num % 3 === 0)) {
	console.log("2の倍数でしかも3の倍数です");
} else {
	console.log("それ以外です");
}
