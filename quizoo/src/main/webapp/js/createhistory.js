/**
 * 
 */

let createHistoryList;

window.addEventListener("load", async () => {
    createHistoryList = await fetch("/quizoo/createhistoryjson", {
        credentials: "include"
    });
    createHistoryList = await createHistoryList.json();
    
    displayCreateHistory(createHistoryList);
});