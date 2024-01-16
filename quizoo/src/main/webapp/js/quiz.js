/**
 * 
 */

let quizlist;
let quiz_id;

window.addEventListener('load',function(){
    quizlist = this.document.querySelector('#quizlist');

    quizId = window.history.state;
    console.log(quizId);
})