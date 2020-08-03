const button = document.getElementById("addBtn");
const lists = document.getElementById("lists");

async function getUsers() {
  //データのやりとり
  const res = await fetch("https://jsonplaceholder.typicode.com/users");

  const users = await res.json();
  return users;
}

async function listUsers() {
  const users = await getUsers();

  //DOM操作

  // for (let index = 0; index < users.length; index++) {
  //   const user = users[index];
  //   const list = document.createElement("li");
  //   list.innerText = user.name;
  //   lists.appendChild(list);
  // }
  users.forEach(function (user) {
    const list = document.createElement("li");
    list.innerText = user.name;
    lists.appendChild(list);
  });
}

button.addEventListener("click", listUsers);

window.addEventListener("load", listUsers);
