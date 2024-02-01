<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<nav class="navbar navbar-light fixed-top">
		<div class="header-img">
			<a href="index"><img src="img/quizoo_nobackground.png"
				alt="quizoo"></a>
		</div>
		<div class="input-group seach-box" id="input-group">
			<input type="text" class="form-control" placeholder="Search" id="search_text">
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
<script src="header.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
