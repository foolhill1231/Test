"use strict";

//13の倍数かどうかを調べる関数。
function isMultiplesOf13(currentValue, index, array) {
	return currentValue % 13 === 0;
}

//空の配列を用意。
let list = [];
//0～100乱数が10個格納された配列を生成。
for(let i = 0; i < 10; i++) {
	list[i] = Math.round(Math.random() * 100);
}
//配列の内容を表示。
console.log(list.toString());

//配列内に13の倍数が含まれるかどうか調べ、結果を表示。
let result = list.some(isMultiplesOf13);
console.log("配列内に13の倍数は含まれるか: " + result);

//list内の各要素を1/100した新しい配列を生成し、表示。
let newList = list.map(function(currentValue, index, array) {
	return currentValue / 100;
});
console.log(newList.toString());
