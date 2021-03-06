// 年月の指定

var year = 2020;
var month = 1;

// var month = document.getElementById('span1').textContent;

// window.onload = function () {
//   console.log(get_month_calendar(year, month));
// };

// window.onload = function () {
//   var data = generate_month_calendar(year, month);
//   document.getElementById('calendar').appendChild(data);
// };

function clickBtn1() {
  const mon = document.form1.month;
  const num = mon.selectedIndex;
  const str = mon.options[num].value;
  document.getElementById('span1').textContent = str;
  console.log(get_month_calendar(year, month));
  var data = generate_month_calendar(year, month);
  document.getElementById('calendar').appendChild(data);
}

/**
 * 指定した年月のカレンダー要素を生成して返す
 * @param {number} year  - 年の指定
 * @param {number} month - 月の指定
 */
function generate_month_calendar(year, month) {
  var weekdayData = ['日', '月', '火', '水', '木', '金', '土'];
  // カレンダーの情報を取得
  var calendarData = get_month_calendar(year, month);

  var i = calendarData[0]['weekday']; // 初日の曜日を取得
  // カレンダー上の初日より前を埋める
  while (i > 0) {
    i--;
    calendarData.unshift({
      day: '',
      weekday: i,
    });
  }
  var i = calendarData[calendarData.length - 1]['weekday']; // 末日の曜日を取得
  // カレンダー上の末日より後を埋める
  while (i < 6) {
    i++;
    calendarData.push({
      day: '',
      weekday: i,
    });
  }

  // カレンダーの要素を生成
  var cTable = document.createElement('table');
  cTable.className = 'calendar-table';

  var insertData = '';
  // 曜日部分の生成
  insertData += '<thead>';
  insertData += '<tr>';
  for (var i = 0; i < weekdayData.length; i++) {
    insertData += '<th>';
    insertData += weekdayData[i];
    insertData += '</th>';
  }
  insertData += '</tr>';
  insertData += '</thead>';

  // 日付部分の生成
  insertData += '<tbody>';
  for (var i = 0; i < calendarData.length; i++) {
    if (calendarData[i]['weekday'] <= 0) {
      insertData += '<tr>';
    }
    insertData += '<td>';
    insertData += calendarData[i]['day'];
    insertData += '</td>';
    if (calendarData[i]['weekday'] >= 6) {
      insertData += '</tr>';
    }
  }
  insertData += '</tbody>';

  cTable.innerHTML = insertData;
  return cTable;
}

/**
 * 指定した年月のカレンダー情報を返す
 * @param {number} year  - 年の指定
 * @param {number} month - 月の指定
 */
function get_month_calendar(year, month) {
  var firstDate = new Date(year, month - 1, 1); // 指定した年月の初日の情報
  var lastDay = new Date(year, firstDate.getMonth() + 1, 0).getDate(); // 指定した年月の末日
  var weekday = firstDate.getDay(); // 指定した年月の初日の曜日

  var calendarData = []; // カレンダーの情報を格納
  var weekdayCount = weekday; // 曜日のカウント用
  for (var i = 0; i < lastDay; i++) {
    calendarData[i] = {
      day: i + 1,
      weekday: weekdayCount,
    };
    // 曜日のカウントが6(土曜日)まできたら0(日曜日)に戻す
    if (weekdayCount >= 6) {
      weekdayCount = 0;
    } else {
      weekdayCount++;
    }
  }
  return calendarData;
}
