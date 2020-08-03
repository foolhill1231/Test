document.writeln('<table>'); 
for(var i=1; i<=9; i++){
   document.writeln('<tr>');

   for(var j=1; j<=9; j++){
      
      if((i%2 == 0 && j%2 == 1)||(i%2 == 1 && j%2 == 0)){   
         document.writeln('<td id="on">' + (i*j) +'</td>');
      }
      else{
         document.writeln('<td id="off">' + (i*j) +'</td>');
      }
   }
   document.writeln('</tr>');
}
document.writeln('</table>');
