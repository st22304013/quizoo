/**
 * 
 */

let quizAndQuestions;
let quiz_id;
let currentQuestionNo;
let selectedAnswers = [];

window.addEventListener('load', async function () {
    questionlist = this.document.querySelector('#question_list');


    // quiz_idをクエリ文字列から取得
    var currentURL = new URL(this.window.location.href);
    var params = currentURL.searchParams;
    quiz_id = params.get('quiz_id');

    quizAndQuestions = await loadQuiz(quiz_id);

    // 選択肢ボタンを設定
    let answerBtns = document.querySelectorAll('#answer_btn button');

    for(let i = 0; i < answerBtns.length; i++) {
        answerBtns[i].addEventListener('click', function() {
            choiceBtnClickHandler(i);
        });
    }

    // 回答送信の確認画面を表示
    document.querySelector('#endButton').addEventListener('click', ()=>{
        this.document.querySelector('#exampleModal').classList.add('show');
    });

    this.document.querySelector("#sendAnswerButton").addEventListener('click', async ()=>{
        // await sendAnswer();
        this.location.href = 'index';
    });

    this.document.querySelector("#dontSendButton").addEventListener('click', ()=>{
        this.document.querySelector('#secondModal').classList.remove('show');
    });


    await displayQuestionsList();
})


async function loadQuiz(quiz_id) {
    var fetchResponse = await fetch('/quizoo/quizquestion?quiz_id=' + quiz_id);
    if (fetchResponse.ok) {
        quizQuestionJson = fetchResponse.json();
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

    currentQuestionNo = questionNo;
    
    let newSnetence = createSentenceNode(questionNo);
    oldSentence.replaceWith(newSnetence);

    let oldChoicesWrapper = document.querySelector('#question-choices');
    let newChoicesWrapper = createChoiseNodes(questionNo);
    oldChoicesWrapper.replaceWith(newChoicesWrapper);
    
    
}


function choiceBtnClickHandler(ClickedNo){
    selectedAnswers[currentQuestionNo - 1] = ClickedNo;
    displayQuestionDetails(currentQuestionNo + 1);
}


function createSentenceNode(questionNo) {
    let willDisplay = quizAndQuestions['question'][questionNo - 1];
    oldSentence = document.querySelector('#question-sentence');
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
