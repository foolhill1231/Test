"use strict";

class TestScore {
	constructor() {
		this.name = "";
		this.english = 0;
		this.math = 0;
		this.japanese = 0;
	}

	//プロパティにまとめてデータをセットするメソッド。
	setData(name = "", english = 0, math = 0, japanese = 0) {
		this.name = name;
		this.english = english;
		this.math = math;
		this.japanese = japanese;
	}
	
	//合計値を計算するメソッド。
	calcSum() {
		let sum = this.english + this.math + this.japanese;
		return sum;
	}

	//平均値を計算するメソッド。
	calcAve() {
		let sum = this.calcSum();
		let ave = sum / 3;
		return ave;
	}
	
	//合計値と平均値を表示するメソッド。
	printScore() {
		let sum = this.calcSum();
		let ave = this.calcAve();
		console.log(this.name + "さんの合計: " + sum + " 平均: " + ave);
	}
}

//たろうさん用のTestScoreAdvを使って、データ表示。
let taro = new TestScore();
taro.setData("たろう", 92, 87, 74);
taro.printScore();

//はなこさん用のTestScoreAdvを使って、データ表示。
let hanako = new TestScore();
hanako.setData("はなこ", 79, 95, 83);
hanako.printScore();

//たろうさんの合計点を取得。
let taroSum = taro.calcSum();
//はなこさんの合計点を取得。
let hanakoSum = hanako.calcSum();
//二人の合計の平均点を算出し、表示。
let ave2 = (taroSum + hanakoSum) / 2;
console.log("二人の合計の平均: " + ave2);

//たろうさんの平均点を取得。
let taroAve = taro.calcAve();
//はなこさんの平均点を取得。
let hanakoAve = hanako.calcAve();
//二人の平均の平均点を算出し、表示。
let aveAve = (taroAve + hanakoAve) / 2;
console.log("二人の平均の平均: " + aveAve);
