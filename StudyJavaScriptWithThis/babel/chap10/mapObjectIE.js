"use strict";

//Mapオブジェクトを生成。

var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

var studentNumList = new Map();
//各クラスの人数を登録。
studentNumList.set("A", 30);
studentNumList.set("B", 31);
studentNumList.set("C", 29);
studentNumList.set("D", 30);
studentNumList.set("E", 32);

//Mapの要素数を取得。
var count = studentNumList.size;
console.log("要素数: " + count);
//C組の人数を取得。
var studentNumC = studentNumList.get("C");
console.log("C組の人数: " + studentNumC);

//Mapのループ。
var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
	for (var _iterator = studentNumList[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
		var _step$value = _slicedToArray(_step.value, 2),
		    key = _step$value[0],
		    value = _step$value[1];

		console.log("キーは" + key + "で値は" + value);
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
