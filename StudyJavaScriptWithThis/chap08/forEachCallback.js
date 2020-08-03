"use strict";

function printElement(currentValue, index, array) {
	console.log((index + 1) + "個目の値: " + currentValue);
}

let list = [2, 7, 66, 4, 9];
list.forEach(printElement);
