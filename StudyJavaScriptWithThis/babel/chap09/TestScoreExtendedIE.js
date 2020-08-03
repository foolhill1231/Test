"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _get = function get(object, property, receiver) { if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { return get(parent, property, receiver); } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } };

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var TestScoreExtended = function (_TestScoreWithConstru) {
	_inherits(TestScoreExtended, _TestScoreWithConstru);

	//コンストラクタ。
	function TestScoreExtended() {
		var name = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : "";
		var english = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 0;
		var math = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : 0;
		var japanese = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : 0;
		var science = arguments.length > 4 && arguments[4] !== undefined ? arguments[4] : 0;
		var social = arguments.length > 5 && arguments[5] !== undefined ? arguments[5] : 0;

		_classCallCheck(this, TestScoreExtended);

		//プロパティの定義、および初期データ格納。
		var _this = _possibleConstructorReturn(this, (TestScoreExtended.__proto__ || Object.getPrototypeOf(TestScoreExtended)).call(this, name, english, math, japanese));
		//親クラスのコンストラクタの呼び出し。


		_this.science = science;
		_this.social = social;
		return _this;
	}

	//5教科の合計点を計算するメソッド。


	_createClass(TestScoreExtended, [{
		key: "calcTotalScore",
		value: function calcTotalScore() {
			//3教科の合計を親クラスのメソッドを使って計算。
			var sum3 = this.calcSum();
			//理科と社会の点を加算して合計を算出。
			var total = sum3 + this.science + this.social;
			return total;
		}

		//5教科の平均点を計算するメソッド。

	}, {
		key: "calcTotalAve",
		value: function calcTotalAve() {
			//calcTotalScore()の戻り値を5で割って平均点を算出。
			var ave = this.calcTotalScore() / 5;
			return ave;
		}

		//合計点と平均点を表示するメソッド。

	}, {
		key: "printScore",
		value: function printScore() {
			//親クラスのprintScore()メソッドの呼び出し。
			_get(TestScoreExtended.prototype.__proto__ || Object.getPrototypeOf(TestScoreExtended.prototype), "printScore", this).call(this);
			//このクラス内のメソッドを使って合計点と平均点を取得。
			var total = this.calcTotalScore();
			var ave = this.calcTotalAve();
			//表示。
			console.log(this.name + "さんの5教科合計: " + total + " 平均: " + ave);
		}
	}]);

	return TestScoreExtended;
}(TestScoreWithConstructor);
