"use strict";

function concatenate(lastName = "", firstName = "", space = "") {
	return lastName + space + firstName;
}
 
let lName = "中田";
let fName = "雄二";
let name1 = concatenate(lName, fName, " ");
console.log("半角スペースで結合: " + name1);
let name2 = concatenate(lName, fName);
console.log("第3引数の渡し忘れ: " + name2);
let name3 = concatenate(lName);
console.log("第2、第3引数の渡し忘れ: " + name3);
let name4 = concatenate();
console.log("全ての引数の渡し忘れ: " + name4);
let name5 = concatenate(undefined, "美奈子");
console.log("引数にundefined: " + name5);
