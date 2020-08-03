"use strict";

function concatenateSpace(lastName, firstName) {
	return lastName + " " + firstName;
}

function useConcatenate(name, func) {
	let concatName = func(...name);
	console.log("結合結果: " + concatName);
}

let nameParam = ["中田", "雄二"];
useConcatenate(nameParam, concatenateSpace);
