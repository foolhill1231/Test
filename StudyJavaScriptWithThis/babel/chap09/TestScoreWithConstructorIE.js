"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var TestScoreWithConstructor = function () {
	//コンストラクタ。
	function TestScoreWithConstructor() {
		var name = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : "";
		var english = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;
		var math = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : 0;
		var japanese = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : 0;

		_classCallCheck(this, TestScoreWithConstructor);

		this.name = name;
		this.english = english;
		this.math = math;
		this.japanese = japanese;
	}

	//合計値を計算するメソッド。


	_createClass(TestScoreWithConstructor, [{
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

	return TestScoreWithConstructor;
}();
