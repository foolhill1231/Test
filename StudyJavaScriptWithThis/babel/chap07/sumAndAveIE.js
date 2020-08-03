"use strict";

var nums = [];
for (var i = 0; i < 30; i++) {
	nums[i] = Math.round(Math.random() * 100);
	console.log(i + 1 + "番目の値=" + nums[i]);
}

var sum = 0;
var max = 0;
var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
	for (var _iterator = nums[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
		var num = _step.value;

		sum += num;
		if (num > max) {
			max = num;
		}
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

var ave = sum / nums.length;
console.log("合計値=" + sum);
console.log("平均値=" + ave);
console.log("最大値=" + max);
