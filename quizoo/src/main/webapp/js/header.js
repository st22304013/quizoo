/**
 * 
 */

document.addEventListener('DOMContentLoaded', function () {
    // ハンバーガーボタンクリックで実行
    document.querySelector("#side-menu-drawer").addEventListener('click', function () {
        document.querySelector("#side-menu").classList.add("show");
    });

    // ドロワーナビゲーションリンククリックで非アクティブ化
    document.querySelector("#side-menu").addEventListener('click',function () {
        if(event.target == document.querySelector("#side-menu-body")) return;
        document.querySelector("#side-menu").classList.remove("show");
    });

});

window.addEventListener('load', function() {
	var pathname = null;
	pathname = location.pathname;

	if (pathname != '/quizoo/index') {
		document.getElementById('input-group').classList.remove('seach-box');

	}
});