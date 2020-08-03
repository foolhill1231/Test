"use strict";

//BMI計算オブジェクト

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var BMI = function () {
	//コンストラクタ。引数は身長と体重。
	function BMI() {
		var height = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 0;
		var weight = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;

		_classCallCheck(this, BMI);

		this.height = height;
		this.weight = weight;
	}

	//BMIを計算するメソッド。


	_createClass(BMI, [{
		key: "getBMI",
		value: function getBMI() {
			//BMIを計算。
			var bmi = this.weight / Math.pow(this.height / 100, 2);
			//以下３行で小数第2位を四捨五入して小数点以下一桁表示に。
			bmi = bmi * 10;
			bmi = Math.round(bmi);
			bmi = bmi / 10;
			//BMIをリターン。
			return bmi;
		}

		//アドバイスを生成するメソッド。

	}, {
		key: "getAdvice",
		value: function getAdvice() {
			//BMIを計算。
			var bmi = this.weight / Math.pow(this.height / 100, 2);
			//BMIの整数値を作成。
			bmi = Math.round(bmi);
			//理想体重を計算。
			var idealWeight = 22 * Math.pow(this.height / 100, 2);
			//理想体重の整数値を作成。
			idealWeight = Math.round(idealWeight);
			//アドバイス用変数を用意。初期値はBMI=22の場合の文字列。
			var adviceMessage = "理想体重です。現状を維持しましょう。";
			//BMIが22より上の場合。
			if (bmi > 22) {
				adviceMessage = "太っています。体重" + idealWeight + "kgを目指しましょう。";
				//BMIが22より下の場合。
			} else if (bmi < 22) {
				adviceMessage = "痩せています。体重" + idealWeight + "kgを目指しましょう。";
			}
			//生成されたアドバイス文字列をリターン。
			return adviceMessage;
		}
	}]);

	return BMI;
}();
