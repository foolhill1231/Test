"use strict";

function concatenate(lastName = "", firstName = "", space = "") {
	return lastName + space + firstName;
}

let nameParam1 = ["中田", "雄二", "・"];
let name1 = concatenate(...nameParam1);
console.log("・で結合: " + name1);
let nameParam2 = ["中田", "雄二"];
let name2 = concatenate(...nameParam2);
console.log("空文字で結合: " + name2);
