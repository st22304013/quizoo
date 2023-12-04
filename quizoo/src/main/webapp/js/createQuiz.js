/*
* クイズ作成モーダル用
*/

let emptyQuestion;
let questions = [];
window.addEventListener("load",function () {
    emptyQuestion = document.querySelector("#question").cloneNode(true);
    this.document.querySelector("#add-question-btn").addEventListener("click",createNewCuestion);
});

function showAllQuestions(){
    for(question of questions){
        console.log(question);
    }
}


function createNewCuestion() {
    addQuestionList();
    resetQuestion();
    updateQuestions();
    showAllQuestions();
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
