/*
* クイズ作成モーダル用
*/

let emptyQuestion;
let emptyModal;
let questions = [];
var modalElement;
var myModal;
var confirmModalElement;
var confirmModal;

var genres = [
    { genre_no: 1, genre_title: "スポーツ" },
    { genre_no: 2, genre_title: "音楽" },
    { genre_no: 3, genre_title: "映画" },
    { genre_no: 4, genre_title: "ゲーム" },
    { genre_no: 5, genre_title: "雑学" },
    { genre_no: 6, genre_title: "宇宙" },
    { genre_no: 7, genre_title: "エンタメ・芸能" },
    { genre_no: 8, genre_title: "なぞなぞ" },
    { genre_no: 9, genre_title: "生き物" },
    { genre_no: 10, genre_title: "歴史" },
    { genre_no: 11, genre_title: "数学" },
    { genre_no: 12, genre_title: "漫画" }
];



window.addEventListener("load",function () {
    modalElement = this.document.querySelector("#myModal1");
    myModal = new bootstrap.Modal(modalElement);
    emptyModal = modalElement.cloneNode(true);
    emptyQuestion = document.querySelector("#question").cloneNode(true);
    confirmModalElement = this.document.querySelector("#comfirm-modal");
    confirmModal = new bootstrap.Modal(confirmModalElement);

    document.querySelector("#add-question-btn").addEventListener("click",function(){
        createNewCuestion();
    });

    document.querySelector("#create-btn-primary").addEventListener("click",async function () {
        document.querySelector("#post-roading").style.display = "block";
        await addQuestionList();
        confirmSubmit();
        console.log("create-btn clicked");
        document.querySelector("#post-roading").style.display = "none";
        modalElement.replaceWith(emptyModal.cloneNode(true));
    });

    this.document.querySelector("#myModal1-open").addEventListener("click",function(){
        myModal.show();
    });

    this.document.querySelector("#confirm-btn-primary").addEventListener("click",function(){
        sendQuiz();
        confirmModal.hide();
    });
    setGenre();
});

function showAllQuestions(){
    for(question of questions){
        console.log(question);
    }
}


async function createNewCuestion() {
    addQuestionList();
    resetQuestion();
    updateQuestions();
    // showAllQuestions();
}


function addQuestionList() {
    let questionNode = document.querySelector("#question");
    let quiz = {
        "quiz":questionNode.querySelector("#create-question-text textarea").value,
        "choise1":questionNode.querySelector('input[name="choise-text1"]').value,
        "choise2":questionNode.querySelector('input[name="choise-text2"]').value,
        "choise3":questionNode.querySelector('input[name="choise-text3"]').value,
        "choise4":questionNode.querySelector('input[name="choise-text4"]').value,
        "judge":[
            questionNode.querySelector('#choise1').checked,
            questionNode.querySelector('#choise2').checked,
            questionNode.querySelector('#choise3').checked,
            questionNode.querySelector('#choise4').checked
        ]
    }

    questions.push(quiz);
}

function resetQuestion(){
    document.querySelector("#question").replaceWith(emptyQuestion.cloneNode(true));
}


function updateQuestions(){
    let questionsWrap = document.createElement("div");
    questionsWrap.setAttribute("class","questions-wrap");
    questionsWrap.setAttribute("id","questions-wrap");
    
    for(let i=0 ; i<  questions.length ; i++){
        question = questions[i];
        quiz = document.createElement('h6');
        quiz.innerText = question["quiz"];
        over = document.createElement('div');
        over.setAttribute('class','question-overview');
        questionI = document.createElement('div');
        questionI.setAttribute('class','question'+i);

        over.appendChild(quiz);
        questionI.appendChild(over);

        questionsWrap.appendChild(questionI);
    }

    oldWrap = document.querySelector("#questions-wrap");
    oldWrap.replaceWith(questionsWrap.cloneNode(true));
}

async function sendQuiz(){
    try{
        var url = location.protocol +"//" +location.host + "/quizoo/submitquiz"
        const response = await fetch(url,{
            method:"POST",
            credentials:"include",
            body:JSON.stringify(questions)
        });
        if(await response.ok){
            console.log("問題の投稿が成功しました");
        }else{
            console.log(await response.status);
        }

    }catch(error){
        console.error("fetch中にエラー発生",error);
    }
    myModal.hide();
}


function setGenre(){

    genreSelector = document.querySelector("#quiz-metadata [name='genre']");
    for(var genre of genres){
        opt = document.createElement('option');
        opt.setAttribute("value",genre['genre_no']);
        opt.innerText = genre['genre_title'];
        genreSelector.appendChild(opt);
    }
}

function confirmSubmit(){
    myModal.hide();
    confirmModal.show();
    return false;
}
