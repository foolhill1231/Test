"use strict";

//たろうさん用のTestScoreExtendedを使って、データ表示。

var taro = new TestScoreExtended("たろう", 92, 87, 74, 81, 79);
var total3 = taro.calcSum();
console.log("3教科の合計: " + total3);
taro.printScore();
