"use strict";

class TestScore {
	constructor() {
		this.name = "";
		this.english = 0;
		this.math = 0;
		this.japanese = 0;
	}
	
	printScore() {
		let sum = this.english + this.math + this.japanese;
		let ave = sum / 3;
		console.log(this.name + "さんの合計: " + sum + " 平均: " + ave);
	}
}

let taro = new TestScore();
taro.name = "たろう";
taro.english = 92;
taro.math = 87;
taro.japanese = 74;
taro.printScore();

let hanako = new TestScore();
hanako.name = "はなこ";
hanako.english = 79;
hanako.math = 95;
hanako.japanese = 83;
hanako.printScore();
