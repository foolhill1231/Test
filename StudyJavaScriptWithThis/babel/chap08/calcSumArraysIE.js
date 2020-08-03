"use strict";

function calcArraySum(list) {
	var sum = 0;
	var _iteratorNormalCompletion = true;
	var _didIteratorError = false;
	var _iteratorError = undefined;

	try {
		for (var _iterator = list[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
			var num = _step.value;

			sum += num;
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

	return sum;
}

var list1 = [5, 6, 10, 55, 4, 9];
var list2 = [2, 7, 66, 4, 9];
var list3 = [8, 6, 13, 6, 9, 11, 5];

var sum1 = calcArraySum(list1);
var sum2 = calcArraySum(list2);
var sum3 = calcArraySum(list3);

console.log("list1の合計: " + sum1);
console.log("list2の合計: " + sum2);
console.log("list3の合計: " + sum3);
