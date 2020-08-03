document.writeln('<table>'); 
var str = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
for(var i=0; i<7; i++){
   document.writeln('<tr>');

   var r = i % 7;
   if(r == 0 || r == 6){   
      document.writeln('<tr id="on">');
   }
   else{
      document.writeln('<tr id="off">');
   }
   document.writeln('<td>'+ str[i] +'</td>');
   document.writeln('</tr>');
}
document.writeln('</table>'); 
