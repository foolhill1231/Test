var str = ["ドーナツ","マシュマロ","チョコレート","クッキー","キャンディー","ポテトチップ"];
document.writeln('<ul>');   
for(var i=0; i<str.length; i++){
   document.writeln('<li>');
   document.writeln(str[i]); 
   document.writeln('</li>');
}
document.writeln('</ul>');
