var str = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
document.writeln("<h1>");
var d = new Date();
var m = d.getMonth();
document.writeln(m + 1 + "月");
document.writeln("</h1>");

document.writeln("<table>");

var fd = new Date(d.getFullYear(), d.getMonth(), 1);
var f = fd.getDay();
var ld = new Date(d.getFullYear(), d.getMonth() + 1, 0);

for (var i = 1; i <= ld.getDate(); i++) {
  document.writeln("<tr>");
  document.writeln("<td>");
  document.writeln(i);
  document.writeln("</td>");
  document.writeln("<td>");
  document.writeln(str[(f + i - 1) % 7]);
  document.writeln("</td>");
  document.writeln("</tr>");
}
document.writeln("</table>");
