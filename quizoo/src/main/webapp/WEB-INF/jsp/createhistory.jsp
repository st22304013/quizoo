<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>作成履歴</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/createhistory.css">
<link rel="stylesheet" href="css/header.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://kit.fontawesome.com/c82cac4dcf.js"
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Zen+Maru+Gothic:wght@500&display=swap" rel="stylesheet">
</head>

<body>
	<!-- ヘッダー -->
	<%@ include file="header.jsp" %>

	<div class="quiz_list">
		<h1 class="createhistory">作成履歴</h1>
		<div class="box" id="createHistoryContainer">
			<div class="width row">
				<div class="title col">常識クイズ</div>
				<div class="d-flex align-items-center col">常識に関するクイズです</div>
				<a href="#" id="modalTrigger" class="garbage_can col"
					data-bs-toggle="modal" data-bs-target="#myModal"> <i
					class="fa-regular fa-trash-can"></i>
				</a>
			</div>
			<div class="information text-right">
				作成者：<a class="author">たまい</a> 作成日：<a class="create_time">2023/10/27</a>
				ジャンル：<a class="genre">雑学</a> 正解率：<a class="raito">22.2%</a>
			</div>

		</div>
	</div>

	<!--	モーダル-->
	<div class="modal fade text-center" id="myModal" tabindex="-1"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-bs-backdrop="static">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">本当に削除しますか？</div>
				<div class="modal-footer">
					<button type="button" class="no-btn btn btn-secondary"
						data-bs-dismiss="modal">いいえ</button>
					<button type="button" class="yes-btn btn btn-primary"
						id="endButton" data-bs-target="#">はい</button>
				</div>
			</div>
		</div>
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
	<script src="js/header.js"></script>
</body>

</html>
