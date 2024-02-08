/**
 * 
 */

document.addEventListener('DOMContentLoaded', function () {
    // ハンバーガーボタンクリックで実行
    document.querySelector("#side-menu-drawer").addEventListener('click', function () {
        this.classList.toggle("active");
        document.querySelector("#side-menu").style.display = "block";
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
});

window.addEventListener('load', function() {
	var pathname = null;
	pathname = location.pathname;
	console.log(pathname);

	if (pathname != '/quizoo/index') {
		document.getElementById('input-group').classList.remove('seach-box');

	}
});