"use strict";

function printScore(name, english, math, japanese) {
	let sum = english + math + japanese;
	let ave = sum / 3;
	console.log(name + "さんの合計: " + sum + " 平均: " + ave);
}

let taroName = "たろう";
let taroEnglish = 92;
let taroMath = 87;
let taroJapanese = 74;
printScore(taroName, taroEnglish, taroMath, taroJapanese);

let hanakoName = "はなこ";
let hanakoEnglish = 79;
let hanakoMath = 95;
let hanakoJapanese = 83;
printScore(hanakoName, hanakoEnglish, hanakoMath, hanakoJapanese);
