"use strict";

let list1 = [5, 6, 10, 55, 4, 9];
let list2 = [2, 7, 66, 4, 9];
let list3 = [8, 6, 13, 6, 9, 11, 5];

let sum1 = 0;
let sum2 = 0;
let sum3 = 0;

for(let num of list1) {
	sum1 += num;
}

for(let num of list2) {
	sum2 += num;
}

for(let num of list3) {
	sum3 += num;
}

console.log("list1の合計: " + sum1);
console.log("list2の合計: " + sum2);
console.log("list3の合計: " + sum3);
