var sum = 0;
var pricelist = {"りんご":500, "みかん":300, "もも":200};
function add()
{
   var itm = myform.items.value;
   var n = myform.num.value;
 
   var e = document.getElementById("table");
   
   var elmr = document.createElement("tr");
   
   var elmd = document.createElement("td");
   var txt = document.createTextNode(itm);
   elmd.appendChild(txt);    
   elmr.appendChild(elmd);

   var elmd = document.createElement("td");
   var txt = document.createTextNode(pricelist[itm]);
   elmd.appendChild(txt);    
   elmr.appendChild(elmd);

   var elmd = document.createElement("td");
   var txt = document.createTextNode(n);
   elmd.appendChild(txt);    
   elmr.appendChild(elmd);

   var c = pricelist[itm]*n;
   sum = sum + c;
   var elmd = document.createElement("td");
   var txt = document.createTextNode(c);
   elmd.appendChild(txt);    
   elmr.appendChild(elmd);

   e.appendChild(elmr);
}
function cls()
{
   var e = document.getElementById("table");
   for(var i=e.childNodes.length-1; i>1; i--){
     e.removeChild(e.childNodes[i]);
   }
   sum = 0;
}
function calc()
{
   window.alert("合計：" + sum + "円");
}