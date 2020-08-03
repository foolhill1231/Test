"use strict";

//Setオブジェクトを生成。
let scoreList = new Set();
//データ登録。
scoreList.add(30);
scoreList.add(31);
scoreList.add(29);
scoreList.add(30);
scoreList.add(32);

//Setの要素数を取得して表示。
let count = scoreList.size;
console.log("要素数: " + count);
//Setのループ。
for(let element of scoreList) {
	console.log(element);
}
