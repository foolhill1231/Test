function init()
{
   var c = document.getElementById("canvas");
   var cnt = c.getContext("2d");

   cnt.shadowBlur = 10;
   cnt.shadowColor = "#00008b";

   for(var i=0; i<300; i++){

      var x = parseInt(Math.random() * 600);
      var y = parseInt(Math.random() * 400);
      var r = parseInt(Math.random() * 255);
      var g = parseInt(Math.random() * 255);
      var b = parseInt(Math.random() * 255);

      cnt.beginPath();
      cnt.arc(x, y, 7, 0, Math.PI*2, false);
      cnt.closePath();

      var color = "rgb(" + r + "," + g + "," + b + ")";      
      cnt.fillStyle = color;
      cnt.fill();
   }
}
