"use strict";

let nameList = ["松田", "田中", "中山", "山本", "本田"];
let nameListStr = nameList.toString();
console.log(nameListStr);
let nameIdx = nameList.indexOf("中山");
console.log("中山さんのインデックス: " + nameIdx);
nameIdx = nameList.indexOf("江口");
console.log("江口さんのインデックス: " + nameIdx);
let includeResult = nameList.includes("江口");
console.log("江口んさんは含まれているか:" + includeResult);
