"use strict";

let csvStr = "JavaScript,PHP,Ruby,Java,Python";
let csvArray = csvStr.split(",");
for(let element of csvArray) {
	console.log(element);
}
