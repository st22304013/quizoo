/*
* クイズ作成モーダル用
*/

let emptyQuestion;
let emptyModal;
let questions = [];
let quizData = {
    "quiz":{
        "title":null,
        "genreNo":0,
        "explanation":null,
    },
    "question":questions
}
var modalElement;
var myModal;
var confirmModalElement;
var confirmModal;

var genres;

fetch("/quizoo/genres").then(response => response.json()).then(data => {
    genres = data;
})



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
        setMetadata();
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
        "question":questionNode.querySelector("#create-question-text textarea").value,
        "choice1":questionNode.querySelector('input[name="choise-text1"]').value,
        "choice2":questionNode.querySelector('input[name="choise-text2"]').value,
        "choice3":questionNode.querySelector('input[name="choise-text3"]').value,
        "choice4":questionNode.querySelector('input[name="choise-text4"]').value,
        "judge":[
            questionNode.querySelector('#choise1').cloneNode(true).checked,
            questionNode.querySelector('#choise2').cloneNode(true).checked,
            questionNode.querySelector('#choise3').cloneNode(true).checked,
            questionNode.querySelector('#choise4').cloneNode(true).checked
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
        quiz.innerText = questions[i]["question"];
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
        var url = "/quizoo/submitquiz"
        const response = await fetch(url,{
            method:"POST",
            credentials:"include",
            body:JSON.stringify(quizData)
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


function setMetadata(){
    title = document.querySelector("#quiz-metadata");
    quizData['quiz']['title'] = title.querySelector("[name = 'title']").value;

    quizData['quiz']['genreNo'] = title.querySelector("[name = genre]").value;

    quizData['quiz']['explanation'] = title.querySelector("[name='explanation']").value;
    console.log(quizData);
}