var isDraw = false;
var bx = 0;
var by = 0;

function init()
{
   var c = document.getElementById("canvas");
   c.addEventListener("mousedown", begin_draw, false);
   c.addEventListener("mousemove", draw, false);
   c.addEventListener("mouseup", end_draw, false);
}
function begin_draw(e)
{
   isDraw = true;
   bx = e.clientX;
   by = e.clientY;
}
function draw(e)
{
   if(isDraw == true){
      var c = document.getElementById("canvas");
      var cnt = c.getContext("2d");

      var x = e.clientX;
      var y = e.clientY;
     
      cnt.shadowBlur = 10;
      cnt.shadowColor = "#FFFFFF";
      cnt.lineWidth = 5;
      cnt.strokeStyle = "#FFFFFF";

      cnt.beginPath();
      cnt.moveTo(bx, by);
      cnt.lineTo(x, y);
      cnt.closePath();
      cnt.stroke();
      bx = x;
      by = y;
  }
}
function end_draw()
{
   isDraw = false;
}
