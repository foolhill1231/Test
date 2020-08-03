"use strict";

var numes = [];
var denomis = [];
for (var i = 0; i <= 4; i++) {
	numes[i] = Math.round(Math.random() * 10);
	denomis[i] = Math.round(Math.random() * 10);
}

var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
	for (var _iterator = denomis[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
		var denomi = _step.value;

		console.log("--分母の値: " + denomi);
		if (denomi === 0) {
			console.log("分母が0ですので、処理を中止します");
			break;
		}
		var _iteratorNormalCompletion2 = true;
		var _didIteratorError2 = false;
		var _iteratorError2 = undefined;

		try {
			for (var _iterator2 = numes[Symbol.iterator](), _step2; !(_iteratorNormalCompletion2 = (_step2 = _iterator2.next()).done); _iteratorNormalCompletion2 = true) {
				var nume = _step2.value;

				console.log("---分子の値: " + nume);
				if (nume === 0) {
					console.log("分子が0ですので、処理を飛ばします");
					continue;
				}
				var ans = nume / denomi;
				console.log("分数値: " + ans);
			}
		} catch (err) {
			_didIteratorError2 = true;
			_iteratorError2 = err;
		} finally {
			try {
				if (!_iteratorNormalCompletion2 && _iterator2.return) {
					_iterator2.return();
				}
			} finally {
				if (_didIteratorError2) {
					throw _iteratorError2;
				}
			}
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
