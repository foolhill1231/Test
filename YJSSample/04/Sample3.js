var d = new Date();
var h = d.getHours();
if(h >= 9 && h < 17){
   document.writeln("ただ今営業中です。");
}
else{
   document.writeln("ただ今閉店中です。");
}
