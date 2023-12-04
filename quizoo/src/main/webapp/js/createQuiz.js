/*
* クイズ作成モーダル用
*/

let emptyQuestion;
let emptyModal;
let questions = [];
var modalElement;
var myModal;

window.addEventListener("load",function () {
    modalElement = this.document.querySelector("#myModal1");
    myModal = new bootstrap.Modal(modalElement);
    emptyModal = modalElement.cloneNode(true);
    emptyQuestion = document.querySelector("#question").cloneNode(true);

    document.querySelector("#add-question-btn").addEventListener("click",function(){
        createNewCuestion();
    });

    document.querySelector("#create-btn-primary").addEventListener("click",async function () {
        document.querySelector("#post-roading").style.display = "block";
        await addQuestionList();
        await sendQuiz();
        console.log("create-btn clicked");
        document.querySelector("#post-roading").style.display = "none";
        modalElement.replaceWith(emptyModal.cloneNode(true));
        myModal.hide();
    });

    this.document.querySelector("#myModal1-open").addEventListener("click",function(){
        myModal.show();
    });
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
    var url = location.protocol +"//" +location.host + "/quizoo/submitquiz"
    try{
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
}
