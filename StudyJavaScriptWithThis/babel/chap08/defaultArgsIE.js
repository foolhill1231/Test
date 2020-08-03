"use strict";

function concatenate() {
  var lastName = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : "";
  var firstName = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";
  var space = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

  return lastName + space + firstName;
}

var lName = "中田";
var fName = "雄二";
var name1 = concatenate(lName, fName, " ");
console.log("半角スペースで結合: " + name1);
var name2 = concatenate(lName, fName);
console.log("第3引数の渡し忘れ: " + name2);
var name3 = concatenate(lName);
console.log("第2、第3引数の渡し忘れ: " + name3);
var name4 = concatenate();
console.log("全ての引数の渡し忘れ: " + name4);
var name5 = concatenate(undefined, "美奈子");
console.log("引数にundefined: " + name5);
