var express = require('express');
var ejs = require("ejs");
var app = express();

app.engine('ejs', ejs.renderFile);

app.get('/', function (req, res) {
  res.render('temp.ejs', {
    contents: '<p>hoge</p>'
  });

});

var server = app.listen(1234, function () {
  console.log('サーバーを起動しました') ；
});