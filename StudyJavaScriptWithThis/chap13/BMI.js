"use strict";

//BMI計算オブジェクト
class BMI {
	//コンストラクタ。引数は身長と体重。
	constructor(height = 0, weight = 0) {
		this.height = height;
		this.weight = weight;
	}

	//BMIを計算するメソッド。
	getBMI() {
		//BMIを計算。
		let bmi = this.weight / Math.pow(this.height/100, 2);
		//以下３行で小数第2位を四捨五入して小数点以下一桁表示に。
		bmi = bmi * 10;
		bmi = Math.round(bmi);
		bmi = bmi / 10;
		//BMIをリターン。
		return bmi;
	}
	
	//アドバイスを生成するメソッド。
	getAdvice() {
		//BMIを計算。
		let bmi = this.weight / Math.pow(this.height/100, 2);
		//BMIの整数値を作成。
		bmi = Math.round(bmi);
		//理想体重を計算。
		let idealWeight = 22 * Math.pow(this.height/100, 2);
		//理想体重の整数値を作成。
		idealWeight = Math.round(idealWeight);
		//アドバイス用変数を用意。初期値はBMI=22の場合の文字列。
		let adviceMessage = "理想体重です。現状を維持しましょう。";
		//BMIが22より上の場合。
		if(bmi > 22) {
			adviceMessage = "太っています。体重" + idealWeight + "kgを目指しましょう。";
		//BMIが22より下の場合。
		} else if(bmi < 22) {
			adviceMessage = "痩せています。体重" + idealWeight + "kgを目指しましょう。";
		}
		//生成されたアドバイス文字列をリターン。
		return adviceMessage;
	}
}
