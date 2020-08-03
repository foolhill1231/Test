"use strict";

function concatenateSpace(lastName, firstName) {
	return lastName + " " + firstName;
}

function concatenateDot(lastName, firstName) {
	return lastName + "・" + firstName;
}

var lName = "中田";
var fName = "雄二";
var funcList = [concatenateSpace, concatenateDot];
var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
	for (var _iterator = funcList[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
		var func = _step.value;

		var name = func(lName, fName);
		console.log("結合結果: " + name);
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
