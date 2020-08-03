"use strict";

//たろうさん用のTestScoreWithConstructorを使って、データ表示。
let taro = new TestScoreWithConstructor("たろう", 92, 87, 74);
taro.printScore();

//はなこさん用のTestScoreWithConstructorを使って、データ表示。
let hanako = new TestScoreWithConstructor("はなこ", 79, 95, 83);
hanako.printScore();

//hanakoオブジェクトのscienceプロパティに89を代入。
hanako.science = 89;
//hanakoオブジェクトのscienceプロパティを表示。
console.log("はなこさんの理科の点: " + hanako.science);
//taroオブジェクトのscienceプロパティを表示。
console.log("たろうさんの理科の点: " + taro.science);
