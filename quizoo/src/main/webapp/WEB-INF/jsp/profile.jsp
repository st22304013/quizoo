<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>quiz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/profile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://kit.fontawesome.com/c82cac4dcf.js"
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
</head>

<body>
	<header>
		<nav class="navbar navbar-light fixed-top">
			<div class="header-img">
				<a href="index"><img src="img/quizoo_nobackground.png" alt="quizoo"></a>
			</div>

			<!-- ハンバーガーメニュー -->
			<buttom class="drawer__button"> <span></span> <span></span>
			<span></span> </buttom>
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
							href="#">ログアウト</a></li>
					</ul>
				</div>
			</nav>
		</nav>
	</header>

	<div class="profile text-center">
		<h1>プロフィール編集</h1>
		<form id="login-form" method="post" action="#">
			<img src="img/prof.png" class="prof-img" alt="icon"><br>
			<!--<div class="custom-file-input">
				<input type="file" class="img" name="img" id="profile-img">
				<label for="profile-img"><i
					class="fa-solid fa-camera-rotate"></i></label>
			</div>  -->
			nickname <input type="text" class="nickname" name="nickname"
				id="profile-nickname" value="今のニックネーム入れる"><br> password
			<input type="password" class="password" name="password"
				id="profile-password"><br>

			<button type="submit" class="buttonRound">編集</button>
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/profile.js"></script>
</body>

</html>