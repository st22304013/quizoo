/**
 * 
 */

const list_box = document.querySelector(".quiz_list");


async function getQuizList() {
    var quizList = await fetch("/quizoo/quizlist");

    quizList = await quizList.json();

    return quizList;

}

async function quizlistFactory(quizList){

    var list = document.createElement('div');
    list.setAttribute('class','quiz_list');
    
    for(quiz of quizList){
        console.log(quiz);

        box = document.createElement('div');
        box.setAttribute('class','box');
        row = document.createElement('div');
        row.setAttribute('class','width row');
        title = document.createElement('div');
        title.setAttribute('class','title col');
        title.innerText = quiz['title'];
        row.appendChild(title);

        explanation = document.createElement('div');
        explanation.setAttribute('class','d-flex align-items-center col');
        explanation.innerText = quiz['explanation'];

        row.appendChild(explanation);

        info = document.createElement('div');
        info.setAttribute('class','information text-right');

        author = document.createElement('a');
        author.setAttribute('class','author');
        author.innerText = quiz['nickname'];
        
        create_time = document.createElement('a');
        create_time.setAttribute('class','create_time');
        create_time.innerText = quiz['createTime'];
        
        ratio = document.createElement('a');
        ratio.setAttribute('class','raito');
        ratio.innerText = ' ' + (parseFloat(quiz['correctRate'])/parseFloat(quiz['questionCount'])).toFixed(2);


        info.appendChild(author);
        info.appendChild(create_time);
        info.appendChild(ratio);    


        box.appendChild(row);
        box.append(info);

        list.appendChild(box);

    }

    return list;
}

(async ()=>{
    quizList = await getQuizList();

    list = await quizlistFactory(quizList);


    list_box.replaceWith(list); 

})();
