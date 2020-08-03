"use strict";

function concatenate() {
	var lastName = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : "";
	var firstName = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";
	var space = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

	return lastName + space + firstName;
}

var nameParam1 = ["中田", "雄二", "・"];
var name1 = concatenate.apply(undefined, nameParam1);
console.log("・で結合: " + name1);
var nameParam2 = ["中田", "雄二"];
var name2 = concatenate.apply(undefined, nameParam2);
console.log("空文字で結合: " + name2);
