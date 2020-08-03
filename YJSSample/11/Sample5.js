function add()
{
   var itm = myform.items.value;

   var e = document.getElementById("table");
   var elmr = document.createElement("tr");
   var elmd = document.createElement("td");
   var txt = document.createTextNode(itm);
   elmd.appendChild(txt);    
   elmr.appendChild(elmd);
   e.appendChild(elmr);
}
