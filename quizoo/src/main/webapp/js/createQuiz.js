let createModal;
window.addEventListener("load",function () {
    createModal = this.window.document.querySelector("#create-quiz-modal-back"); 

    this.document.querySelector("#create-quiz-open").addEventListener("click",showQreateModal);
})

function showQreateModal() {
    createModal.style.display = "block";
}
