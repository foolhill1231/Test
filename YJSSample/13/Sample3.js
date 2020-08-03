var img = new Image();
img.src = "pic.jpg";

function init()
{
   var c = document.getElementById("canvas");  
   var cnt = c.getContext("2d");

   cnt.globalAlpha = 0.2;
   for(var i=0; i<200; i=i+10){
      cnt.drawImage(img, i*5, i*2);
   } 
}
