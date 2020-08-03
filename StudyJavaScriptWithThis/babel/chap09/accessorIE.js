"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var AccessorProp = function () {
	//コンストラクタ。氏名を受け取りプロパティに格納。
	function AccessorProp(lastName, firstName) {
		_classCallCheck(this, AccessorProp);

		this.lastName = lastName;
		this.firstName = firstName;
	}

	//nameプロパティのゲッタ。


	_createClass(AccessorProp, [{
		key: "name",
		get: function get() {
			return this.lastName + this.firstName;
		}

		//extNameプロパティのセッタ。

	}, {
		key: "extName",
		set: function set(value) {
			this.lastName = value;
			this.firstName = value;
		}
	}]);

	return AccessorProp;
}();

//「中田太郎」という氏名でAccessorPropオブジェクトを生成。


var taro = new AccessorProp("中田", "太郎");
//各プロパティを表示。
console.log("lastName: " + taro.lastName);
console.log("firstName: " + taro.firstName);
//nameプロパティを表示。
console.log("name: " + taro.name);

//extNameプロパティに「山口次郎」を代入。
taro.extName = "山口次郎";
//各プロパティを表示。
console.log("lastName: " + taro.lastName);
console.log("firstName: " + taro.firstName);

//extNameプロパティを表示。
console.log("extName: " + taro.extName);

//nameプロパティに「篠原三郎」を代入したうえで同プロパティを表示。
taro.name = "篠原三郎";
console.log("name: " + taro.name);
