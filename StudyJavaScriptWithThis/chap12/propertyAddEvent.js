"use strict";

//画面がロードされたタイミングで行う処理。
window.onload = function() {
	//ドロップダウン要素を取得。
	let paymentSelect = document.getElementById("paymentSelect");
	//ドロップダウンが変更されたタイミングで行う処理。
	paymentSelect.onchange = function() {
		//選択されたドロップダウンのvalue値を取得。
		let paymentSelectStr = paymentSelect.value;
		//取得したvalue値を数値型に変換。
		let paymentSelectInt = Number(paymentSelectStr);
		//手数料表示用の文字列を用意。
		let paymentSelectResultStr = "手数料: "
		//取得したvalue値に応じて処理を分岐。
		switch(paymentSelectInt) {
			case 1:
				paymentSelectResultStr += "432円";
				break;
			case 2:
				paymentSelectResultStr += "80円";
				break;
			case 3:
				paymentSelectResultStr += "0円";
				break;
			case 4:
				paymentSelectResultStr += "300円";
				break;
			default:
				paymentSelectResultStr = ""
		}
		//手数料を表示する要素を取得。
		let paymentSelectResult = document.getElementById("paymentSelectResult");
		//手数料を表示。
		paymentSelectResult.textContent = paymentSelectResultStr;
	};
};
