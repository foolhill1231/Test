function down()
{
   var e = document.getElementById("description");
   var t = document.createTextNode("写真のご説明をいたします。");
   e.appendChild(t);
}
function up()
{
   var e = document.getElementById("description");
   e.removeChild(e.lastChild);
}
