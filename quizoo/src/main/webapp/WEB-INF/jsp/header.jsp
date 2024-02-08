<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<div class="index-link">
		<a href="index"></a>
		<img src="img/quizoo_nobackground.png"
			alt="quizoo">
	</div>
	<input class="search-txtbox" id="search-textbox" type="text" placeholder="Search">
	<button class="side-menu-drawer" id="side-menu-drawer">
		<span></span> <span></span> <span></span>
	</button>
</header>

<!-- ハンバーガー -->
<div class="side-menu" id="side-menu">
	<ul id="side-menu-body">
		<li><a href="profile">プロフィール編集</a></li>
		<li><a href="createhistory">作成履歴</a></li>
		<li><a href="score">スコア詳細</a></li>
		<li><a href="logout">ログアウト</a></li>
	</ul>
</div>
<script src="js/header.js"></script>
