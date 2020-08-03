var k=0;
var t=null;
function stat()
{
   if(t == null)
      t = window.setInterval("tick()", 3000);
}
function stop()
{
   window.clearInterval(t);
   t = null;  
}
function tick()
{
   k++;
   if(k >= 15) k=0;
   var e = document.getElementById("bigimage");
   e.setAttribute("src", "pic" + k +".jpg");
}
