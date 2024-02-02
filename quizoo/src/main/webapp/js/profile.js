/**
 * 
 */
const form = document.getElementById("login-form");

let nicknameList;
window.addEventListener("load", async () => {
    nicknameList = await fetch("/quizoo/nickname", {
        credentials: "include"
    })
    nicknameList = await nicknameList.json();
    nickname = nicknameList[0];
    document.getElementById('profile-nickname').value = nickname;

});

function sendData() {
}


//// 'submit' イトのハンドラーを追加
form.addEventListener("submit", async () => {
    var newName = document.querySelector("#profileickname");

    console.log(nme.value);

    var result = fetch("/quizoo/updatenickname?nime=test",{
      head:{
            "Content-Type":"applition/json"
        },
        body:`{nickname=${newName.value}}`,
      meod:"post",
        credentials:"include",
    })

    event.preventDefault();

    sendData();
});

// 'submit' イベントのハンドラーを追加
form.addEventListener("submit", async (event) => {
    var newpassword = document.querySelector("#profile-password");

    console.log(newpassword.value);

    var result = fetch("/quizoo/updatepassword?password=test",{
        head:{
            "Content-Type":"application/json"
        },
        body:`{password=${newpassword.value}}`,
        method:"post",
        credentials:"include",
    })

    event.preventDefault();

    sendData();
});