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

function displayCreateHistory(createHistoryData) {
    const container = document.getElementById('createHistoryContainer');

    createHistoryData.forEach(historyItem => {
        const historyHtml = `
            <div class="box" id="createHistoryContainer">
                <div class="width row">
                    <div class="title col">${historyItem.title}</div>
                    <div class="d-flex align-items-center col">${historyItem.description}</div>
                    <a href="#" class="garbage_can col" data-bs-toggle="modal" data-bs-target="#myModal">
                        <i class="fa-regular fa-trash-can"></i>
                    </a>
                </div>
                <div class="information text-right">
                    作成者：<a class="author">${historyItem.author}</a>
                    作成日：<a class="create_time">${historyItem.createDate}</a>
                    ジャンル：<a class="genre">${historyItem.genre}</a>
                    正解率：<a class="raito">${historyItem.accuracy}</a>
                </div>
            </div>
        `;

        container.insertAdjacentHTML('beforeend', historyHtml);
    });
}