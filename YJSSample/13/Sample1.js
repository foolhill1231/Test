function init()
{
   var c = document.getElementById("canvas");
   var cnt = c.getContext("2d");

   cnt.shadowBlur = 10;
   cnt.shadowColor = "#00008b";

   cnt.strokeStyle = "#00008b";
   cnt.fillStyle = "#FFFFFF";
   cnt.fillRect(0, 0, 100, 100);
   cnt.fill();

   cnt.fillStyle = "#000000";

   cnt.beginPath();
   cnt.arc(25, 25, 10, 0, Math.PI*2, false);
   cnt.closePath();
   cnt.fill();

   cnt.beginPath();
   cnt.arc(50, 50, 10, 0, Math.PI*2, false);
   cnt.closePath();
   cnt.fill();

   cnt.beginPath();
   cnt.arc(75, 75, 10, 0, Math.PI*2, false);
   cnt.closePath();
   cnt.fill();
}
