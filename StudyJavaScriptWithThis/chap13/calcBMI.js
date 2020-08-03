"use strict";

//［計算］ボタンがクリックされた時の処理関数。
function onCalcBMIButtonClick() {
	//身長入力input要素を取得。
	let heightInput = document.getElementById("heightInput");
	//入力された身長の値を取得。
	let height = heightInput.value;
	//体重入力input要素を取得。
	let weightInput = document.getElementById("weightInput");
	//入力された体重の値を取得。
	let weight = weightInput.value;
	
	//BMI計算オブジェクトを生成。身長と体重を渡す。
	let bmiObj = new BMI(height, weight);
	//BMIを取得。
	let bmi = bmiObj.getBMI();

	//BMIを表示するspan要素を取得。
	let bmiResult = document.getElementById("bmiResult");
	//BMIを表示。
	bmiResult.textContent = bmi;

	//アドバイスを取得。
	let advice = bmiObj.getAdvice();
	//アドバイスを表示するspan要素を取得。
	let adviceMessage = document.getElementById("adviceMessage");
	//アドバイスを表示。
	adviceMessage.textContent = advice;

	//結果を表示するp要素を取得。
	let resultMessage = document.getElementById("resultMessage");
	//非表示にしているクラス属性を削除。
	resultMessage.classList.remove("displayNone");
}

//画面がロードされた時の処理を登録。
window.addEventListener("DOMContentLoaded", function() {
	//身長のinput要素を取得。
	let heightInput = document.getElementById("heightInput");
	//身長入力欄が変更された時の処理を登録。
	heightInput.addEventListener("input", checkInput);
	//身長入力欄からフォーカスが外れた時の処理を登録。
	heightInput.addEventListener("blur", checkInput);
	
	//体重のinput要素を取得。
	let weightInput = document.getElementById("weightInput");
	//体重入力欄が変更された時の処理を登録。
	weightInput.addEventListener("input", checkInput);
	//体重入力欄からフォーカスが外れた時の処理を登録。
	weightInput.addEventListener("blur", checkInput);

	//バリデーション用関数。
	function checkInput() {
		//［計算］ボタンを有効にするかどうかのフラグ。
		let buttonEnabled = true;

		//入力された身長の値を取得。
		let heightStr = heightInput.value;
		//入力値は文字列なので数値に変換
		let height = Number(heightStr);
		//身長のバリデーションメッセージを表示するspan要素を取得。
		let heightInputMsg = document.getElementById("heightInputMsg");
		//未入力なら…
		if(heightStr.length === 0) {
			//［計算］ボタンを無効に。
			buttonEnabled = false;
			//バリデーションメッセージを表示。
			heightInputMsg.textContent = "身長を入力してください。";
		//数値以外が入力されたなら…
		} else if(!Number.isFinite(height)) {
			buttonEnabled = false;
			heightInputMsg.textContent = "身長には数値を入力してください。";
		//0以下が入力されたなら…
		} else if(height <= 0) {
			buttonEnabled = false;
			heightInputMsg.textContent = "身長には正数を入力してください。";
		//入力値が適切なら…
		} else {
			//バリデーションメッセージを削除。
			heightInputMsg.textContent = "";
		}

		let weightStr = weightInput.value;
		let weight = Number(weightStr);
		let weightInputMsg = document.getElementById("weightInputMsg");
		if(weightStr.length === 0) {
			buttonEnabled = false;
			weightInputMsg.textContent = "体重を入力してください。";
		} else if(!Number.isFinite(weight)) {
			buttonEnabled = false;
			weightInputMsg.textContent = "体重には数値を入力してください。";
		} else if(weight <= 0) {
			buttonEnabled = false;
			weightInputMsg.textContent = "体重には正数を入力してください。";
		} else {
			weightInputMsg.textContent = "";
		}

		//［計算］ボタン要素を取得。
		let calcBMIButton = document.getElementById("calcBMIButton");
		//［計算］ボタンが有効なら…
		if(buttonEnabled) {
			//disabled属性を削除。
			calcBMIButton.removeAttribute("disabled");
		//［計算］ボタンが無効なら…
		} else {
			//disabled属性を追加。
			calcBMIButton.setAttribute("disabled", "disabled");
		}
	}
});
