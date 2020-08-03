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
