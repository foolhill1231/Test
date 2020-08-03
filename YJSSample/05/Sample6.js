document.writeln('<table>'); 
document.writeln('<tr>');
for(var i=0; i<6; i++){
   if(i % 2 == 0){   
      document.writeln('<td id="on">');
   }
   else{
      document.writeln('<td id="off">');
   }
   document.writeln('No.'+ i);
   document.writeln('</td>');
}
document.writeln('</tr>');
document.writeln('</table>'); 
