var d = new Date();
var day = d.getDay();
switch(day){
   case 0:
      document.writeln("今日は日曜です。");
      break;
   case 6: 
      document.writeln("今日は土曜です。");
      break;
   default:
      document.writeln("今日は平日です。");
}
