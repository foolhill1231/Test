var a = navigator.userAgent;
var ios = a.indexOf("iPhone")>0 || a.indexOf("iPad")>0 || a.indexOf("iPod")>0; 
var android =  a.indexOf("Android")>0;

if(ios == true || android == true){
   document.writeln('<link rel="stylesheet" href="SamplePhone.css">');
}
else{
   document.writeln('<link rel="stylesheet" href="SamplePC.css">');
}
