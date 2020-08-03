"use strict";

//Mapオブジェクトを生成。
let studentNumList = new Map();
//各クラスの人数を登録。
studentNumList.set("A", 30);
studentNumList.set("B", 31);
studentNumList.set("C", 29);
studentNumList.set("D", 30);
studentNumList.set("E", 32);

//Mapの要素数を取得。
let count = studentNumList.size;
console.log("要素数: " + count);
//C組の人数を取得。
let studentNumC = studentNumList.get("C");
console.log("C組の人数: " + studentNumC);

//Mapのループ。
for(let [key, value] of studentNumList) {
	console.log("キーは" + key + "で値は" + value);
}
