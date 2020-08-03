var img = new Image();
var i = 1.0;
function init()
{
   img.src = "pic.jpg";
   var t = window.setInterval("draw()", 300);
}
function draw()
{
   var c = document.getElementById("canvas");  
   var w = c.width;
   var h = c.height;
   var cnt = c.getContext("2d");

   cnt.clearRect(0, 0, w, h);
   if(i< 0.0) i=1.0;
   i = i - 0.1;
   cnt.globalAlpha = i;
   
   cnt.drawImage(img, 0, 0);
}
