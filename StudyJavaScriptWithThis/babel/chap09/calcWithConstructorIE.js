"use strict";

//たろうさん用のTestScoreWithConstructorを使って、データ表示。

var taro = new TestScoreWithConstructor("たろう", 92, 87, 74);
taro.printScore();

//はなこさん用のTestScoreWithConstructorを使って、データ表示。
var hanako = new TestScoreWithConstructor("はなこ", 79, 95, 83);
hanako.printScore();

//たろうさんの合計点を取得。
var taroSum = taro.calcSum();
//はなこさんの合計点を取得。
var hanakoSum = hanako.calcSum();
//二人の合計の平均点を算出し、表示。
var ave2 = (taroSum + hanakoSum) / 2;
console.log("二人の合計の平均: " + ave2);

//たろうさんの平均点を取得。
var taroAve = taro.calcAve();
//はなこさんの平均点を取得。
var hanakoAve = hanako.calcAve();
//二人の平均の平均点を算出し、表示。
var aveAve = (taroAve + hanakoAve) / 2;
console.log("二人の平均の平均: " + aveAve);
