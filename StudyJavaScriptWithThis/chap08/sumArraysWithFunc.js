"use strict";

function sumArray(list) {
	let sum = 0;
	for(let num of list) {
		sum += num;
	}
	console.log("合計値: " + sum);
}

let list1 = [5, 6, 10, 55, 4, 9];
let list2 = [2, 7, 66, 4, 9];
let list3 = [8, 6, 13, 6, 9, 11, 5];

sumArray(list1);
sumArray(list2);
sumArray(list3);
