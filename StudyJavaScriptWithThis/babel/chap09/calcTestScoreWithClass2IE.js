"use strict";

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var TestScore = function TestScore() {
	_classCallCheck(this, TestScore);

	this.name = "";
	this.english = 0;
	this.math = 0;
	this.japanese = 0;
};

function printScore(student) {
	var sum = student.english + student.math + student.japanese;
	var ave = sum / 3;
	console.log(student.name + "さんの合計: " + sum + " 平均: " + ave);
}

var taro = new TestScore();
taro.name = "たろう";
taro.english = 92;
taro.math = 87;
taro.japanese = 74;
printScore(taro);

var hanako = new TestScore();
hanako.name = "はなこ";
hanako.english = 79;
hanako.math = 95;
hanako.japanese = 83;
printScore(hanako);
