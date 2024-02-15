/**
 * 
 */
const form = document.getElementById("login-form");


//// 'submit' イベントのハンドラーを追加
form.addEventListener("submit", async (event) => {
    var newName = document.querySelector("#profile-nickname");
   
    
   
    var result = fetch("/quizoo/updatenickname?nickname=test",{
      head:{
            "Content-Type":"application/json"
        },
        body:`{nickname=${newName.value}}`,
        method:"post",
        credentials:"include",
    })
	
    event.preventDefault();

    sendData();
});

// 'submit' イベントのハンドラーを追加
form.addEventListener("submit", async (event) => {
    var newpassword = document.querySelector("#profile-password");

   

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