"use strict";

let str = "";
for(let count = 1; count <= 11; count++) {
	if(count % 2 === 0) {
		str += "☆\n";
	} else {
		str += "★\n";
	}
}
console.log(str);
