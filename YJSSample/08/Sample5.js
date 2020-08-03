var i = 0;
function change()
{
   i++;
   if(i >= 6) i=0;
   document.image.src = "pic" + i +".jpg";
}

