"use strict";

let nums = [];
for(let i = 0; i < 30; i++) {
	nums[i] = Math.round(Math.random() * 100);
	console.log((i+1) + "番目の値=" + nums[i]);
}

let sum = 0;
let max = 0;
for(let num of nums) {
	sum += num;
	if(num > max) {
		max = num;
	}
}
let ave = sum / nums.length;
console.log("合計値=" + sum);
console.log("平均値=" + ave);
console.log("最大値=" + max);
