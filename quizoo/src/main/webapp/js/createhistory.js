/**
 * 
 */

let createHistoryList;

window.addEventListener("load", async () => {
    try {
        const response = await fetch("/quizoo/createhistoryjson", {
            credentials: "include"
        });

        createHistoryList = await response.json();

        // createHistoryList が存在するか確認
        if (!Array.isArray(createHistoryList) || createHistoryList.length === 0) {
            console.error("Error: createHistoryList is null or undefined");
            return;
        }

        const historyListElement = displayCreateHistory(createHistoryList);
        // コード修正: 作成したリストを DOM に追加
        document.body.appendChild(historyListElement);
    } catch (error) {
        console.error("Error fetching data:", error);
    }
});

function displayCreateHistory(createHistoryData) {
    const list = document.createElement('div');
    list.setAttribute('class', 'quiz_list');
    list.setAttribute('id', 'quiz_list');
    for (let quiz of createHistoryData) {
        const box = document.createElement('div');
        box.setAttribute('class', 'quiz');

        const row = document.createElement('div');
        row.setAttribute('class', 'width row');

        const title = document.createElement('div');
        title.setAttribute('class', 'title col');
        title.innerText = quiz['title'];
        row.appendChild(title);

        const explanation = document.createElement('div');
        explanation.setAttribute('class', 'd-flex align-items-center col');
        explanation.innerText = quiz['explanation'] ? quiz['explanation'] : "";
        row.appendChild(explanation);

        const info = document.createElement('div');
        info.setAttribute('class', 'information text-right');

        const create_time = document.createElement('a');
        create_time.setAttribute('class', 'create_time');
        create_time.innerText = quiz['createTime'];

        const genre = document.createElement('a');
        // コード修正: genre の href 属性を確認する
        genre.setAttribute('href', quiz['genre_no']);
        genre.innerText = quiz['genre'];

        const ratio = document.createElement('a');
        ratio.setAttribute('class', 'raito');
        if (quiz['questionCount'] == 0) {
            ratio.innerText = 'nodata'
        } else {
            ratio.innerText = ' ' + (parseFloat(quiz['correctRate']) / parseFloat(quiz['questionCount'])).toFixed(2)
        }

        const garbageCan = document.createElement('a');
        garbageCan.setAttribute('href', '#');
        garbageCan.setAttribute('class', 'garbage_can col');
        garbageCan.setAttribute('data-bs-toggle', 'modal');
        garbageCan.setAttribute('data-bs-target', '#myModal');

        const trashIcon = document.createElement('i');
        trashIcon.setAttribute('class', 'fa-regular fa-trash-can');

        garbageCan.appendChild(trashIcon);
        info.appendChild(create_time);
        info.appendChild(genre);
        info.appendChild(ratio);
        info.appendChild(garbageCan);

        box.appendChild(row);
        box.appendChild(info);

        list.appendChild(box);
    }

    return list;
}
