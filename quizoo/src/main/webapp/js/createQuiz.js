let createModal;
let metadataModal;
let questionEditors = [];
let EditingQuestionNo = 0;
let genres;
fetch("/quizoo/genres").then(response => response.json()).then(data => {
    genres = data;
})
window.addEventListener("load",function () {
    createModal = this.window.document.querySelector("#create-quiz-modal-back"); 
    metadataModal = this.window.document.querySelector("#metadata-modal-back");

    this.document.querySelector("#create-quiz-open").addEventListener("click",showQreateModal);
    this.document.querySelector("#add-question").addEventListener("click",addQuestion);
    this.document.querySelector("#submit-quiz-btn").addEventListener("click",showMetadataModal);
    this.document.querySelector("#cancel-quiz-btn").addEventListener("click",showQreateModal);
    this.document.querySelector("#post-quiz-btn").addEventListener("click",postQuiz);
})

function showQreateModal() {
    metadataModal.style.display = "none";
    createModal.style.display = "block";
}
function showMetadataModal(){
    storeQuestionEditor();
    for(var genre of genres){
        var option = document.createElement("option");
        option.value = genre['genre_no'];
        option.innerText = genre['genre_title'];
        document.querySelector("#post-genres").appendChild(option.cloneNode(true));
    }

    createModal.style.display = "none";
    metadataModal.style.display = "block";
}


// 現在作成中のクエスチョンを保存
function storeQuestionEditor() {
    currentEditor = document.querySelector("#question-editor");

    // 問題文を入力していないときは何もしない
    if(!currentEditor.querySelector("#question-text").value) return;

    // 作成中の情報を保存
    questionEditors[EditingQuestionNo] = currentEditor;
    

    // 空のクエスチョン一覧を作成
    var storedQuestion = document.createElement("div");
    storedQuestion.setAttribute("class","stored-question");
    storedQuestion.setAttribute("id","stored-question");

    // questionEditorsから情報を取り出し、クエスチョン一覧に表示
    for(var i = 0 ; i < questionEditors.length ; i++) {
        var overview = document.createElement("div");
        overview.setAttribute("class","question-overview");
        overview.innerText = questionEditors[i].querySelector("#question-text").value;
        overview.addEventListener("click",changeQuestionEditor.bind(null,i));
        storedQuestion.appendChild(overview);
    }

    // 追加ボタンをクローン
    var addBtn = document.querySelector("#add-question").cloneNode(true);
    // イベントはcloneNodeで継承されないので、ここで再設定
    addBtn.addEventListener("click",addQuestion);
    storedQuestion.appendChild(addBtn);
    
    // クエスチョン一覧を置き換え
    document.querySelector("#stored-question").replaceWith(storedQuestion);

}

//　編集する問題を切り返す
function changeQuestionEditor(questionNo){
    // questionNoが無いときは何もしない
    if(questionNo == undefined || questionNo == null || questionNo < 0 || questionNo >= questionEditors.length) return;
    // 現在開いている問題と同じときは何もしない
    if(EditingQuestionNo == questionNo) return;

    // 現在開いている問題を保存
    storeQuestionEditor();

    EditingQuestionNo = questionNo;
    document.querySelector("#question-editor").replaceWith(questionEditors[questionNo].cloneNode(true));
} 

// クエスチョンを追加する
function addQuestion(){
    // 現在作成中のクエスチョンを保存
    storeQuestionEditor();
    
    let emptyEditor;
    // 初回のみ空のクエスチョンを作成
    if(!emptyEditor){
        emptyEditor = document.createElement("div");
        emptyEditor.setAttribute("class","question-editor");
        emptyEditor.setAttribute("id","question-editor");

        var text = document.createElement("textarea");
        text.setAttribute("type","text");
        text.setAttribute("name","question-text");
        text.setAttribute("class","question-text");
        text.setAttribute("id","question-text");
        emptyEditor.appendChild(text);

        var filedset = document.createElement("fieldset");
        filedset.setAttribute("class","choices");
        for(let i = 1 ; i <= 4 ; i++){
            var choice = document.createElement("div");
            choice.setAttribute("class","choice");

            var radio = document.createElement("input");
            radio.setAttribute("type","radio");
            radio.setAttribute("name","choice");
            radio.setAttribute("id",i);
            choice.appendChild(radio);

            var text = document.createElement("input");
            text.setAttribute("type","text");
            text.setAttribute("name","choisce-text");
            text.setAttribute("class","choice-text");
            text.setAttribute("id","choice-text");

            choice.appendChild(text);

            filedset.appendChild(choice);
        }
        emptyEditor.appendChild(filedset);
    }

    EditingQuestionNo = questionEditors.length;
    document.querySelector("#question-editor").replaceWith(emptyEditor.cloneNode(true));
}

// 問題を投稿する
function postQuiz(){
    let quidatas = [];
    for(var editor of questionEditors){
        quidatas.push({
            "question":editor.querySelector("#question-text").value,
            "choice1":editor.querySelector("#choice1-text").value,
            "choice2":editor.querySelector("#choice2-text").value,
            "choice3":editor.querySelector("#choice3-text").value,
            "choice4":editor.querySelector("#choice4-text").value,
            "judge":[
                editor.querySelectorAll("#choice")[0].checked,
                editor.querySelectorAll("#choice")[1].checked,
                editor.querySelectorAll("#choice")[2].checked,
                editor.querySelectorAll("#choice")[3].checked
            ]
        });
    }
    console.log(JSON.stringify(quidatas));
    fetch("/quizoo/submitquiz",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            "question":quidatas
        })
    }).catch((err)=>{
        console.log(err);
    })
}