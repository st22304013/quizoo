/**
 * 
 */

/**
 * 
 */

import { Modal } from "bootstrap";

let quizAndQuestions;
let quiz_id;
let currentQuestionNo;
let selectedAnswers;
let answerBtns;
let questionlist; // Declare questionlist variable
let confirmModal; //送信確認のモーダル

window.addEventListener('load', async function () {
    // モーダルを取得
    confirmModal = new Modal(this.document.querySelector("#exampleModal"));

    questionlist = this.document.querySelector('#question_list');

    // quiz_idをクエリ文字列から取得
    var currentURL = new URL(this.window.location.href);
    var params = currentURL.searchParams;
    quiz_id = params.get('quiz_id');

    quizAndQuestions = await loadQuiz(quiz_id);

    selectedAnswers = new Array(quizAndQuestions['question'].length);

    // 選択肢ボタンを設定
    answerBtns = document.querySelectorAll('#answer_btn button');

    for(let i = 0; i < answerBtns.length; i++) {
        answerBtns[i].addEventListener('click', function() {
            choiceBtnClickHandler(i);
            chengeSelected(i);
        });
    }

    // 回答送信の確認画面を表示
    document.querySelector('#endButton').addEventListener('click', ()=>{
        confirmModal.show();
    });

    this.document.querySelector("#sendAnswerButton").addEventListener('click', async ()=>{
        // await sendAnswer();
        confirmModal.hide();
        // scoring();
        // this.location.href = 'index';
    });

    this.document.querySelector("#dontSendButton").addEventListener('click', ()=>{
        this.document.querySelector('#secondModal').classList.remove('show');
    });

    await displayQuestionsList();

    await displayQuestionDetails(1);

    scoring();
})

// Rest of the code remains unchanged



async function loadQuiz(quiz_id) {
    var fetchResponse = await fetch('/quizoo/quizquestion?quiz_id=' + quiz_id);
    if (fetchResponse.ok) {
        var quizQuestionJson = fetchResponse.json();
        return quizQuestionJson;
    } else {
        // redirect('/quizoo/error');
        alert('fetchError!! \n ');
    }
}

async function displayQuestionsList() {
    const newQuestionlist = document.createElement('ol');
    newQuestionlist.setAttribute('id', 'question_list');

    for (const question of quizAndQuestions['question']) {
        const questionElement = document.createElement('li');
        questionElement.innerText = question['question'];

        questionElement.addEventListener('click', () => {
            return displayQuestionDetails(question.questionId);
        });
        
        newQuestionlist.appendChild(questionElement);
    }

    questionlist.replaceWith(newQuestionlist);
}

function displayQuestionDetails(questionNo) {
    if (questionNo === currentQuestionNo)  return;
    if (questionNo > quizAndQuestions['question'].length || questionNo < 0) return;
    let oldSentence = document.querySelector('#question-sentence');

    currentQuestionNo = questionNo;
    
    let newSnetence = createSentenceNode(questionNo);
    oldSentence.replaceWith(newSnetence);

    let oldChoicesWrapper = document.querySelector('#question-choices');
    let newChoicesWrapper = createChoiseNodes(questionNo);
    oldChoicesWrapper.replaceWith(newChoicesWrapper);
    
    chengeSelected(selectedAnswers[currentQuestionNo - 1]);
}


function choiceBtnClickHandler(ClickedNo){
    selectedAnswers[currentQuestionNo - 1] = ClickedNo;
    displayQuestionDetails(currentQuestionNo + 1);
}


function createSentenceNode(questionNo) {
    let willDisplay = quizAndQuestions['question'][questionNo - 1];
    let newSnetence = document.createElement('div');
    newSnetence.setAttribute('class', 'sentence');
    newSnetence.setAttribute('id', 'question-sentence');
    newSnetence.innerText = willDisplay['question'];

    return newSnetence;
}

function createChoiseNodes(questionNo) {
    let newChoicesWrapper = document.createElement('div');
    newChoicesWrapper.setAttribute('class','answer');
    newChoicesWrapper.setAttribute('id','question-choices');

    let question = quizAndQuestions['question'][questionNo - 1];

    // 一時的になし
    // choiceBtn.setAttribute('class', '');
    
    for(let i = 1; i <= 4; i++) {
        let choiceBtn = document.createElement('div');
        choiceBtn.setAttribute('class','choice');
        choiceBtn.innerText = question['choice'+i];
        newChoicesWrapper.appendChild(choiceBtn);
    }

    return newChoicesWrapper;

}

async function sendAnswer(){
    let response = await fetch('/quizoo/submitanswer', {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'quiz_id': quiz_id,
            'answers': selectedAnswers
        })
    });
}


function chengeSelected(selectedNo = 0) {
    for(let i = 0; i < answerBtns.length; i++) {
        if(selectedNo === i){
            answerBtns[i].classList.add('selected');
        }else{
            answerBtns[i].classList.remove('selected');
        }
    }
}

function scoring() {
    let score = 0;
    for(let i = 0; i < selectedAnswers.length; i++) {
        if(quizAndQuestions['question'][i]['judge'][selectedAnswers[i]]) {
            score++;
        }
    }
    console.log(score);
}
