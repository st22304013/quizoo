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
    this.document.querySelector('#create-close-btn').addEventListener('click', hideCreateModal);
    this.document.querySelector('#metadata-close-btn').addEventListener('click', hideMetadataModal);
})

// クイズ作成モーダルを表示
function showQreateModal() {
    // クイズリストをスクロールしないようにする
    document.body.style.overflow = "hidden";

    metadataModal.style.display = "none";
    createModal.style.display = "block";
}
// クイズ作成モーダルを非表示
function hideCreateModal() {
    // クイズリストをスクロールするようにする
    document.body.style.overflow = "auto";

    createModal.style.display = "none";
}
// クイズ作成モーダルを初期化
function clearCreateModal(){
    addQuestion();
    questionEditors = [];
    EditingQuestionNo = 0;
    updateQuestions();
}
// クイズ作成モーダルを表示
function showMetadataModal(){
    storeQuestionEditor();
    // クエスチョンが無い場合は投稿できない
    if(questionEditors.length == 0){
        document.querySelector("#question-text").setCustomValidity("最低1つの問題を作成してください。");
        document.querySelector("#question-text").reportValidity();
        return;
    }
    for(var genre of genres){
        var option = document.createElement("option");
        option.value = genre['genre_no'];
        option.innerText = genre['genre_title'];
        document.querySelector("#post-genres").appendChild(option.cloneNode(true));
    }

    // クイズリストをスクロールしないようにする
    document.body.style.overflow = "hidden";

    createModal.style.display = "none";
    metadataModal.style.display = "block";
}
//　クイズ作成モーダルを非表示
function hideMetadataModal() {
    // クイズリストをスクロールするようにする
    document.body.style.overflow = "auto";

    metadataModal.style.display = "none";
    
}
// クイズ作成モーダルを初期化
function clearMetadataModal() {
    document.querySelector("#post-title").value = "";
    document.querySelector("#post-explanation").value = "";
    document.querySelector("#post-genres").value = -1;
}




// 現在作成中のクエスチョンを保存
function storeQuestionEditor() {
    currentEditor = document.querySelector("#question-editor");

    // 問題文を入力していないときは何もしない
    if(!currentEditor.querySelector("#question-text").value) return;

    // 作成中の情報を保存
    questionEditors[EditingQuestionNo] = currentEditor;
    
    // 作成中の情報を表示
    updateQuestions();
    
}

// クエスチョン一覧を更新
function updateQuestions(){
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

//　編集する問題を切り変える
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
        text.setAttribute("placeholder","問題文");
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
            text.setAttribute("placeholder",`選択肢${i}`);

            choice.appendChild(text);

            filedset.appendChild(choice);
        }
        emptyEditor.appendChild(filedset);
    }

    EditingQuestionNo = questionEditors.length;
    document.querySelector("#question-editor").replaceWith(emptyEditor.cloneNode(true));
}

//投稿中メッセージ

function showPostingMessage(){
    document.querySelector("#snackbar").classList.add("show");
}

function hidePostingMessage(){
    document.querySelector("#snackbar").classList.remove("show");
}

// 問題を投稿する
async function postQuiz(){
    hideCreateModal();
    hideMetadataModal();
    showPostingMessage();
    
    let questionDatas = [];
    for(var editor of questionEditors){
        questionDatas.push({
            "question":editor.querySelector("#question-text").value,
            "choice1":editor.querySelector("#choice-text").value,
            "choice2":editor.querySelector("#choice-text").value,
            "choice3":editor.querySelector("#choice-text").value,
            "choice4":editor.querySelector("#choice-text").value,
            "judge":[
                editor.querySelectorAll("[name='choice']")[0].checked,
                editor.querySelectorAll("[name='choice']")[1].checked,
                editor.querySelectorAll("[name='choice']")[2].checked,
                editor.querySelectorAll("[name='choice']")[3].checked
            ]
        });
    }
    let medaData = {
        "title":metadataModal.querySelector("#post-title").value,
        "genreNo":metadataModal.querySelector("#post-genres").value,
        "explanation":metadataModal.querySelector("#post-explanation").value
    }
    await fetch("/quizoo/submitquiz",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            "quiz":medaData,
            "question":questionDatas
        }),
        credentials:"include"
    }).catch((err)=>{
        console.log(err);
    });
    hidePostingMessage();
    clearCreateModal();
    clearMetadataModal();

    // updateQuizListは別ファイルのため確認して実行
    if(updateQuizList){
        updateQuizList();
    }
}