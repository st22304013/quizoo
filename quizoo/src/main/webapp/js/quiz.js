/**
 * 
 */

let quizlist;
let quiz_id;

window.addEventListener('load',function(){
    quizlist = this.document.querySelector('#quizlist');

    // quiz_id‚ðƒNƒGƒŠ•¶Žš—ñ‚©‚çŽæ“¾
    var currentURL = new URL(this.window.location.href);
    var params = currentURL.searchParams;
    quiz_id = params.get('quiz_id');

    loadQuiz(quiz_id)
})


async function loadQuiz(quiz_id){
    var result = await fetch('/quizoo/quizquestion?quiz_id='+quiz_id);
    if(result.ok){
        quizQuestionJson = result.json();
    }else{
        // redirect('/quizoo/error');
    }
}

function redirect(url){
    location.href = url;
}