<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<nav class="navbar navbar-light fixed-top">
		<div class="header-img">
			<a href="index"><img src="img/quizoo_nobackground.png"
				alt="quizoo"></a>
		</div>
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search">
			<div class="input-group-append">
				<span class="input-group-text"> <svg
						xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16"
						height="16">
								<path
							d="M10.68 11.74a6 6 0 0 1-7.922-8.982 6 6 0 0 1 8.982 7.922l3.04 3.04a.749.749 0 0 1-.326 1.275.749.749 0 0 1-.734-.215ZM11.5 7a4.499 4.499 0 1 0-8.997 0A4.499 4.499 0 0 0 11.5 7Z">
								</path>
							</svg>
				</span>
			</div>
		</div>
		<!-- ハンバーガーメニュー -->
		<button class="drawer__button">
			<span></span> <span></span> <span></span>
		</button>
		<nav class="drawer__nav">
			<div class="drawer__nav__inner">
				<ul class="drawer__nav__menu">
					<li class="drawer__nav__item"><a class="drawer__nav__link"
						href="profile">プロフィール編集</a></li>
					<li class="drawer__nav__item"><a class="drawer__nav__link"
						href="createhistory">作成履歴</a></li>
					<li class="drawer__nav__item"><a class="drawer__nav__link"
						href="score">スコア詳細</a></li>
					<li class="drawer__nav__item"><a class="drawer__nav__link"
						href="logout">ログアウト</a></li>
				</ul>
			</div>
		</nav>

	</nav>
</header>

<!--	ハンバーガー -->
<script>
	$(function() {
		// ハンバーガーボタンクリックで実行
		$(".drawer__button").click(function() {
			$(this).toggleClass("active");
			$(".drawer__nav").toggleClass("active");
		});

		$(".drawer__nav__link").click(function() {
			$(".drawer__button").removeClass("active");
			$(".drawer__nav").removeClass("active");
		});

		// ページ内スクロール
		$('a[href^="#"]').click(function() {
			const speed = 400;
			let href = $(this).attr("href");
			let target = $(href == "#" || href == "" ? "html" : href);
			let position = target.offset().top;
			$("body,html").animate({
				scrollTop : position
			}, speed, "swing");
			return false;
		});
		// function
	});
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
