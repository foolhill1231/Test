var d = new Date();
var day = d.getDay();
if(day == 0){
   document.writeln("今日は休日です。");
}
else{
   document.writeln("今日は平日です。");
}
