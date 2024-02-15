<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>index</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/header.css">
		<script src="https://kit.fontawesome.com/44f79b56c2.js" crossorigin="anonymous"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Zen+Maru+Gothic:wght@500&display=swap" rel="stylesheet">
</head>

<body>
    <!-- 上のヘッダー -->
    <%@ include file="header.jsp" %>
    <!-- 下のヘッダー-->
    <header class="order-menu">
		<a id="order_btn">new</a>
		<a id="order_btn">popular</a>
			<select id="genre_selector" class="genre_selector">
			</select>
    </header>
    <!-- クイズリスト  -->
    <div class="quiz_list" id="quiz_list">
        <div class="quiz">
            <div class="width row">
                <div class="title col">
                    <p>常識クイズ</p>
                </div>
            </div>
        </div>
    </div>

    <div class="fixed-bottom text-right create-quiz-btn">
        <a href="#" id="create-quiz-open" class="create-quiz-open" data-slide-index="1"> 
        	<i class="fa-solid fa-pen"></i>
        </a>
    </div>

    <!--作問ポップアップ-->
    <div id="create-quiz-modal-back" class="create-quiz-modal-back">
        <div id="create-quiz-modal" class="create-quiz-modal">
	        <span id="create-close-btn" class="create-close-btn"><i class="close-btn fa-solid fa-xmark"></i></span>
            <div id="stored-question" class="stored-question">
                <div id="add-question" class="add-question">
                    <span><i class="fa-solid fa-plus"></i></span><span>問題を追加する</span>
                </div>
            </div>
            <div id="question-editor" class="question-editor">
                <textarea id="question-text" class="question-text" placeholder="問題文"></textarea>
                <fieldset id="choices" class="choices">
                    <div class="choice" class="choice">
                        <input type="radio" id="1">
                        <input type="text" id="choice-text" class="choice-text" placeholder="選択肢">
                    </div>
                    <div class="choice" class="choice">
                        <input type="radio" id="2">
                        <input type="text" class="choice-text" id="choice-text">
                    </div>
                    <div class="choice"  class="choice">
                        <input type="radio" id="3">
                        <input type="text" class="choice-text" id="choice-text">
                    </div>
                    <div class="choice" class="choice">
                        <input type="radio" id="4">
                        <input type="text" class="choice-text" id="choice-text">
                    </div>
                </fieldset>
            </div>
            <!-- 完了ボタン -->
            <div id="submit-quiz-btn" class="submit-quiz-btn">
                <i class="fa-solid fa-arrow-right"></i>
            </div>
        </div>
    </div>

    <!-- 作問確認ポップアップ -->
    <div id="metadata-modal-back" class="metadata-modal-back">
        <div id="metadata-modal" class="metadata-modal">
	        <span id="metadata-close-btn" class="metadata-close-btn"><i class="close-btn fa-solid fa-xmark"></i></span>
            <h5>以下の内容で投稿します</h5>
            <div id="quiz-metadata" class="quiz-metadata">
                    <input type="text" id="post-title" placeholder="タイトル">
                    <select id="post-genres">
                    </select>
                    <input type="text" id="post-explanation" placeholder="説明">
            </div>
            <div class="metadata-buttons">
                <button id="cancel-quiz-btn" class="cancel-quiz-btn"><i></i> 修正</button>
                <button id="post-quiz-btn" class="post-quiz-btn"><i></i> 投稿</button>
            </div>
        </div>
    </div>
    
    <script src="js/index.js"></script>
    <script src="js/createQuiz.js"></script>
</body>

</html>
