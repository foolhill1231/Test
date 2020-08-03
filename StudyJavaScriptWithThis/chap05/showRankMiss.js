"use strict";

let score = Math.round(Math.random() * 100);
console.log("得点: " + score);
if(score >= 80) {
	console.log("成績は優です");
}
if(score >= 70) {
	console.log("成績は良です");
}
if(score >= 60) {
	console.log("成績は可です");
} else {
	console.log("成績は不可です");
}
