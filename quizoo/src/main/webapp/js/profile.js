/**
 * 
 */
let nicknameList;
window.addEventListener("load", async () =>{
    nicknameList = await fetch("/quizoo/nickname",{
        credentials: "include"
    })
    nicknameList = await nicknameList.json();
    nickname = nicknameList[0];
    document.getElementById('profile-nickname').value = nickname;

});

function sendData() {
    const XHR = new XMLHttpRequest();

    // FormData オブジェクトと form 要素を紐づけます
    const FD = new FormData(form);

    // データが正常に送信された場合に行うことを定義します
    XHR.addEventListener("load", (event) => {
      alert(document.getElementById('profile-nickname').value);
    });

    // エラーが発生した場合に行うことを定義します
    XHR.addEventListener("error", (event) => {
      alert("Oops! Something went wrong.");
    });

    // リクエストをセットアップします
    XHR.open("POST", "updatenickname");

    // 送信したデータは、ユーザーがフォームで提供したものです
    XHR.send(document.getElementById('profile-nickname').value);
  }

  // form 要素を取得
  const form = document.getElementById("login-form");

  // 'submit' イベントのハンドラーを追加
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    sendData();
  });