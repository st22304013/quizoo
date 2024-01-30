/**
 * 
*/
var list_box;

window.addEventListener('load',function(){
    list_box = document.querySelector("#quiz_list");
    
    orderBtns = document.querySelectorAll(".order_btn");
    for(var btn of orderBtns){
        btn.addEventListener("click",function () {
            history.replaceState(null,null, window.location.pathname + "?order=" + this.innerText);
            getQuizList();
            
        });
        
    }
    (async ()=>{
        quizList = await getQuizList();
    
        list = await quizlistFactory(quizList);
    
    
        list_box.replaceWith(list); 
    
    })();

    // ハンバーガーボタンクリックで実行
    document.querySelector(".drawer__button").addEventListener('click', function () {
        this.classList.toggle("active");
        document.querySelector(".drawer__nav").classList.toggle("active");
    });

    // ドロワーナビゲーションリンククリックで非アクティブ化
    document.querySelectorAll(".drawer__nav__link").forEach(function (link) {
        link.addEventListener('click', function () {
            document.querySelector(".drawer__button").classList.remove("active");
            document.querySelector(".drawer__nav").classList.remove("active");
        });
    });

    // ページ内スクロール
    document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();

            const speed = 400;
            let href = this.getAttribute("href");
            let target = document.querySelector(href === "#" || href === "" ? "html" : href);
            let position = target.offsetTop;

            window.scrollTo({
                top: position,
                behavior: "smooth"
            });
        });
    });
})

async function getQuizList() {
    params = new URLSearchParams(window.location.search);

    param = params.get("order");

    if(param){
        param = "?order="+param;
    }else{
        param = "";
    }

    var quizList = await fetch("/quizoo/quizlist" + param);

    quizList = await quizList.json();

    return quizList;

}

async function quizlistFactory(quizList){
    var list = document.createElement('div');
    list.setAttribute('class','quiz_list');
    for(quiz of quizList){
        box = document.createElement('div');
        box.setAttribute('class','quiz');
        
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
        
        
        create_time = document.createElement('a');
        create_time.setAttribute('class','create_time');
        create_time.innerText = quiz['createTime'];
        
        genre = document.createElement('a');
        genre.setAttribute('href',quiz['genre_no']);
        genre.innerText = quiz['genre'];
        
        ratio = document.createElement('a');
        ratio.setAttribute('class','raito');
        if(quiz['questionCount'] ==  0){
            ratio.innerText = '回答者なし'
        }else{
            ratio.innerText = ' ' + (parseFloat(quiz['correctRate'])/parseFloat(quiz['questionCount'])).toFixed(2)
        }
        
        author = document.createElement('a');
        author.setAttribute('class','author');

        let nickname = quiz['authorNickname'];
        author.innerText = nickname ? nickname : "名無しさん";
        author.setAttribute('href','profile?user_no='+quiz['authorNo']);
        
        info.appendChild(author);
        info.appendChild(create_time);
        info.appendChild(genre);
        info.appendChild(ratio);    
        
        
        box.appendChild(row);

        link = document.createElement('a');
        link.setAttribute('href','answer?quiz_id='+quiz['quizId']);
        link.setAttribute('class','answer-link')
        box.appendChild(link);
        
        box.append(info);

        list.appendChild(box);

    }

    return list;
}

