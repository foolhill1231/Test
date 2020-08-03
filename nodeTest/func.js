var hoge = function () { }


hoge.prototype.add = function (val1, val2) {
  return val1 + val2;
}

hoge.prototype.sub = function (val1, val2) {
  return val1 - val2;
}

var hoge = new hoge();

module.exports = hoge;
