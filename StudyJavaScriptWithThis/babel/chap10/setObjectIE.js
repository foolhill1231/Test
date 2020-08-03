"use strict";

//Setオブジェクトを生成。

var scoreList = new Set();
//データ登録。
scoreList.add(30);
scoreList.add(31);
scoreList.add(29);
scoreList.add(30);
scoreList.add(32);

//Setの要素数を取得して表示。
var count = scoreList.size;
console.log("要素数: " + count);
//Setのループ。
var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
	for (var _iterator = scoreList[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
		var element = _step.value;

		console.log(element);
	}
} catch (err) {
	_didIteratorError = true;
	_iteratorError = err;
} finally {
	try {
		if (!_iteratorNormalCompletion && _iterator.return) {
			_iterator.return();
		}
	} finally {
		if (_didIteratorError) {
			throw _iteratorError;
		}
	}
}
