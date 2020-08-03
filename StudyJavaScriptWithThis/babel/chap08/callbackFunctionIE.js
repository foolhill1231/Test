"use strict";

function _toConsumableArray(arr) { if (Array.isArray(arr)) { for (var i = 0, arr2 = Array(arr.length); i < arr.length; i++) { arr2[i] = arr[i]; } return arr2; } else { return Array.from(arr); } }

function concatenateSpace(lastName, firstName) {
	return lastName + " " + firstName;
}

function useConcatenate(name, func) {
	var concatName = func.apply(undefined, _toConsumableArray(name));
	console.log("結合結果: " + concatName);
}

var nameParam = ["中田", "雄二"];
useConcatenate(nameParam, concatenateSpace);
