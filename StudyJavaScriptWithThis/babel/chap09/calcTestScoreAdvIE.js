"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var TestScore = function () {
	function TestScore() {
		_classCallCheck(this, TestScore);

		this.name = "";
		this.english = 0;
		this.math = 0;
		this.japanese = 0;
	}

	//プロパティにまとめてデータをセットするメソッド。


	_createClass(TestScore, [{
		key: "setData",
		value: function setData() {
			var name = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : "";
			var english = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;
			var math = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : 0;
			var japanese = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : 0;

			this.name = name;
			this.english = english;
			this.math = math;
			this.japanese = japanese;
		}

		//合計値を計算するメソッド。

	}, {
		key: "calcSum",
		value: function calcSum() {
			var sum = this.english + this.math + this.japanese;
			return sum;
		}

		//平均値を計算するメソッド。

	}, {
		key: "calcAve",
		value: function calcAve() {
			var sum = this.calcSum();
			var ave = sum / 3;
			return ave;
		}

		//合計値と平均値を表示するメソッド。

	}, {
		key: "printScore",
		value: function printScore() {
			var sum = this.calcSum();
			var ave = this.calcAve();
			console.log(this.name + "さんの合計: " + sum + " 平均: " + ave);
		}
	}]);

	return TestScore;
}();

//たろうさん用のTestScoreAdvを使って、データ表示。


var taro = new TestScore();
taro.setData("たろう", 92, 87, 74);
taro.printScore();

//はなこさん用のTestScoreAdvを使って、データ表示。
var hanako = new TestScore();
hanako.setData("はなこ", 79, 95, 83);
hanako.printScore();

//たろうさんの合計点を取得。
var taroSum = taro.calcSum();
//はなこさんの合計点を取得。
var hanakoSum = hanako.calcSum();
//二人の合計の平均点を算出し、表示。
var ave2 = (taroSum + hanakoSum) / 2;
console.log("二人の合計の平均: " + ave2);

//たろうさんの平均点を取得。
var taroAve = taro.calcAve();
//はなこさんの平均点を取得。
var hanakoAve = hanako.calcAve();
//二人の平均の平均点を算出し、表示。
var aveAve = (taroAve + hanakoAve) / 2;
console.log("二人の平均の平均: " + aveAve);
