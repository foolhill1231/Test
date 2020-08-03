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
	}, {
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
	}]);

	return TestScore;
}();

var taro = new TestScore();
taro.setData("たろう", 92, 87, 74);
taro.printScore();

var hanako = new TestScore();
hanako.setData("はなこ", 79, 95, 83);
hanako.printScore();
