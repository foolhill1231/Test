var d = new Date();
var day = d.getDay();
if(day == 0){
   document.writeln("今日は日曜です。");
}
else if(day == 6){
   document.writeln("今日は土曜です。");
}
else{
   document.writeln("今日は平日です。");
}
