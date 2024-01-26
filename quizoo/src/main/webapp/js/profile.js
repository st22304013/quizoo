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






