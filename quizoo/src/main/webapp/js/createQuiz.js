let createModal;
let questionEditors = [];
let EditingQuestionNo = 0;
window.addEventListener("load",function () {
    createModal = this.window.document.querySelector("#create-quiz-modal-back"); 

    this.document.querySelector("#create-quiz-open").addEventListener("click",showQreateModal);
    this.document.querySelector("#add-question").addEventListener("click",storeQuestionEditor);
})

function showQreateModal() {
    createModal.style.display = "block";
}

function storeQuestionEditor() {
    currentEditor = document.querySelector("#question-editor");
    questionEditors[EditingQuestionNo] = currentEditor;
    
    var storedQuestion = document.createElement("div");
    storedQuestion.setAttribute("class","stored-question");
    storedQuestion.setAttribute("id","stored-question");


    for(let i = 0 ; i < questionEditors.length ; i++) {
        var overview = document.createElement("div");
        overview.setAttribute("class","question-overview");
        overview.innerText = questionEditors[i].querySelector("#question-text").value;
        storedQuestion.appendChild(overview);
    }

    storedQuestion.appendChild(document.querySelector("#add-question").cloneNode(true));
    
    document.querySelector("#stored-question").replaceWith(storedQuestion.cloneNode(true));
}
