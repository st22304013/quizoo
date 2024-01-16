/**
 * 
 */

let quizAndQuestions;
let quiz_id;

window.addEventListener('load',async function(){
    questionlist = this.document.querySelector('#question_list');

    // quiz_id‚ðƒNƒGƒŠ•¶Žš—ñ‚©‚çŽæ“¾
    var currentURL = new URL(this.window.location.href);
    var params = currentURL.searchParams;
    quiz_id = params.get('quiz_id');

    quizAndQuestions = await loadQuiz(quiz_id);

    await displayQuestionsList(quizAndQuestions['question']);
})


async function loadQuiz(quiz_id){
    var fetchResponse = await fetch('/quizoo/quizquestion?quiz_id='+quiz_id);
    if(fetchResponse.ok){
        quizQuestionJson = fetchResponse.json();
        return quizQuestionJson;
    }else{
        // redirect('/quizoo/error');
        alert('fetchError!! \n ');
    }
}

async function displayQuestionsList(questions){
    var newQuestionlist = document.createElement('ol');
    newQuestionlist.setAttribute('id','question_list');

    for(var question of questions){
        var questionElement = document.createElement('li');
        questionElement.innerText = question['question'];
        newQuestionlist.appendChild(questionElement);
    }

    questionlist.replaceWith(newQuestionlist);
}


function redirect(url){
    location.href = url;
}