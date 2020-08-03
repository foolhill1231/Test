"use strict";

//［すべて…］チェックボックスをクリックしたときの処理関数。
function onCheckallChanged() {
	//［すべて…］チェックボックス要素を取得。
	let checkall = document.getElementById("checkall");
	//［すべて…］のチェック状態に合わせて表示文字列を変更。
	if(checkall.checked) {
		checkall.nextSibling.textContent = "すべて外す";
	} else {
		checkall.nextSibling.textContent = "すべてチェック";
	}
	//name属性がskillのチェックボックス要素を取得。
	let checkboxes = document.getElementsByName("skill");
	//name属性がskillのチェックボックス要素をループ処理。
	for(let i = 0; i < checkboxes.length; i++) {
		//各チェックボックスのチェック状態を［すべて…］に合わせる。
		checkboxes[i].checked = checkall.checked;
	}
}
