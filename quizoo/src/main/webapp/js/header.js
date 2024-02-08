/**
 * 
 */

document.addEventListener('DOMContentLoaded', function () {
    // ハンバーガーボタンクリックで実行
    document.querySelector("#side-menu-drawer").addEventListener('click', function () {
        document.querySelector("#side-menu").style.display = "block";
    });

    // ドロワーナビゲーションリンククリックで非アクティブ化
    document.querySelector("#side-menu").addEventListener('click',function () {
        if(event.target == document.querySelector("#side-menu-body")) return;
        document.querySelector("#side-menu").style.display = "none";
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
});

window.addEventListener('load', function() {
	var pathname = null;
	pathname = location.pathname;
	console.log(pathname);

	if (pathname != '/quizoo/index') {
		document.getElementById('input-group').classList.remove('seach-box');

	}
});