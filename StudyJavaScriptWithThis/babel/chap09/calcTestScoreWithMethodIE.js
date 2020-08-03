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

	_createClass(TestScore, [{
		key: "printScore",
		value: function printScore() {
			var sum = this.english + this.math + this.japanese;
			var ave = sum / 3;
			console.log(this.name + "さんの合計: " + sum + " 平均: " + ave);
		}
	}]);

	return TestScore;
}();

var taro = new TestScore();
taro.name = "たろう";
taro.english = 92;
taro.math = 87;
taro.japanese = 74;
taro.printScore();

var hanako = new TestScore();
hanako.name = "はなこ";
hanako.english = 79;
hanako.math = 95;
hanako.japanese = 83;
hanako.printScore();
