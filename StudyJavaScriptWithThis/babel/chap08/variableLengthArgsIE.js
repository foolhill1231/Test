"use strict";

function concatenate() {
	var concatenatedName = "";

	for (var _len = arguments.length, name = Array(_len), _key = 0; _key < _len; _key++) {
		name[_key] = arguments[_key];
	}

	for (var i = 0; i < name.length; i++) {
		concatenatedName += name[i];
		if (i != name.length - 1) {
			concatenatedName += "・";
		}
	}
	return concatenatedName;
}

var lName = "中田";
var fName = "雄二";
var name1 = concatenate(fName, lName);
console.log("結合結果: " + name1);
var picasso = concatenate("パブロ", "ディエゴ", "ホセ", "フランシスコ", "デ", "パウラ", "ファン", "ネポムセーノ", "マリア", "デ", "ロス", "レメディオス", "シプリアノ", "デ", "ラ", "サンティシマ", "トリニダード", "ルイス", "ピカソ");
console.log("ピカソの本名: " + picasso);
