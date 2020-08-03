"use strict";

let month = Math.round(Math.random() * 12);
switch(month) {
	case 3:
	case 4:
	case 5:
		console.log(month + "月は春です!");
		break;
	case 6:
		console.log(month + "月は梅雨です!");
		break;
	case 7:
	case 8:
	case 9:
		console.log(month + "月は夏です!");
		break;
	case 10:
	case 11:
		console.log(month + "月は秋です!");
		break;
	case 12:
	case 1:
	case 2:
		console.log(month + "月は冬です!");
		break;
}
