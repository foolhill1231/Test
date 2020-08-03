var i=0;
function init()
{
   window.setInterval("tick()", 3000);
}
function tick()
{
   i++;
   if(i >= 6) i=0;
   var e = document.getElementById("image");
   e.setAttribute("src", "pic" + i +".jpg");
}
