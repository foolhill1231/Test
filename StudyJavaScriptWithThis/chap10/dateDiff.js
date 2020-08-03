"use strict";

//2011年10月5日のDateオブジェクトを生成。
let jobs = new Date(2011, 9, 5);
//jobsのUNIXエポックからのミリ秒を取得。
let jobsMills = jobs.getTime();

//現在の日時を取得し、表示。
let now = new Date();
console.log("現在の日時: " + now.toLocaleString());
//nowのUNIXエポックからのミリ秒を取得。
let nowMills = now.getTime();
//jobsとnowのミリ秒の差分を計算。
let diffMills = nowMills - jobsMills;
//差分のミリ秒を日に換算し、表示。
let diffDate = diffMills / (1000 * 60 * 60 * 24);
console.log("ジョブズの命日からの経過日: " + Math.floor(diffDate) + "日");
