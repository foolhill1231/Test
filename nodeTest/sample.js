//httpオブジェクト生成　require
var http = require('http');
//fsオブジェクト生成
var fs = require('fs');
//url文字列解析
var url = require('url');
//クエリ文字列
// var qs = require('querystring');

// var indexPage = fs.readFileSync('./index.html', 'utf-8');

//サーバーオブジェクト生成 (httpリクエストオブジェクト,httpレスポンスオブジェクト)
// var server = http.createServer(function (req, res) {

//   if (req.method = 'GET') {
//       //(url,true->解析結果オブジェクトqueryプロパティをオブジェクト型で保持)
//       var urlParts = url.parse(req.url, true);
//       console.log('---GET Request---');
//     console.log(`nameは${urlParts.query.name}`);
//       console.log('ageは' + urlParts.query.age);

//     } else {
//       var body = '';
//       req.on('data', function (data) {
//         body += data;

//       });

//       req.on('end', function () {
//         var params = qs.parse(body);
//         console.log('---POST Request---');
//         console.log('nameは' + params.name);
//         console.log('ageは' + params.age);
//       });

//     }

// //コールバック巻数 httpヘッダ書き出し(ステータスコード,ヘッダ情報連想配列)
//   res.writeHead(200, { 'Content-Type': 'text/html' });
// //コンテンツ書き出し
//   res.write('Hello world');
// //コンテンツ出力完了
//   res.end();
// });

//   res.write(indexPage);
//   res.end();
// });

// var nextPage = fs.readFileSync('./next.html', 'utf-8');

// var server = http.createServer(function (req, res) {
//   var target = '';
//   switch (req.url) {
//     case '/':
//     case '/index':
//       // target = './index.html';
//       target = indexPage;
//       break;
    
//     case '/next':
//       // target = './next.html';
//       target = nextPage;
//       break;
//     default:
//       res.writeHead(404, { 'Content-Type': 'text/plain' });
//       res.end('bad request');
//       return;
//   }
  
//   fs.readFile(target, 'utf-8', function (err, data) {
//     res.writeHead(200, { 'Content-Type': 'text/html' });
//     res.write(target);
//     res.end();
//   });
// });

//   res.writeHead(200, { 'Content-Type': 'text/html' });
//   res.write(target);
//   res.end();

// });

// var url = require('url');
// var qs = require('querystring');





// var server = http.createServer(function (req, res) {
//    //htmlファイル読み込み(ファイルパス,エンコード,コールバック巻数(エラーオブジェクト,読み込んだデータ))非同期動作
//    fs.readFile('./temp.html', 'utf-8', function (err, data) {

// var server = http.createServer(function (req, res) {
//   var urlParts = url.parse(req.url);
//   var path = __dirname + '/' + urlParts.pathname;
//   var stream = fs.createReadStream(path);

//   stream.on('data', function (data) {
//     res.write(data);

//   });
//   stream.on('end', function (data) {
//     res.end();
//   });
// });
//ポート番号指定　サーバー待ち受け状態(ポート番号)

var func = require('./func');
console.log(func.add(1, 2));
console.log(func.sub(10, 3));
// server.listen(1234);
// console.log('サーバーを起動しました');
