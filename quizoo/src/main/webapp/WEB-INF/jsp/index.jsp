<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>index</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/header.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Zen+Maru+Gothic:wght@500&display=swap" rel="stylesheet">
</head>

<body>
    <!-- 上のヘッダー -->
    <%@ include file="header.jsp" %>
    <!-- 下のヘッダー-->
    <header class="order-menu">
        <ul>
            <li><a>new</a></li>
            <li><a>popular</a></li>
            <li>
                <select id="genre_selector">
                </select>
            </li>
        </ul>
    </header>
    <!-- クイズリスト  -->
    <div class="quiz_list mx-auto" id="quiz_list">
        <div class="quiz">
            <div class="width row">
                <div class="title col">
                    <p>常識クイズ</p>
                </div>
            </div>
        </div>
    </div>

    <div class="fixed-bottom text-right">
        <a href="#" id="create-quiz-open" data-slide-index="1"> <i></i>
        </a>
    </div>

    <!--作問ポップアップ-->
    <div id="create-quiz-modal-back">
        <span id="create-close-btn"></span>
        <div id="create-quiz-modal">
            <div id="stored-question">
                <div id="add-question">
                    <span><i></i></span><span>問題を追加する</span>
                </div>
            </div>
            <div id="question-editor">
                <textarea id="question-text" placeholder="問題文"></textarea>
                <fieldset id="choices">
                    <div class="choice">
                        <input type="radio" id="1">
                        <input type="text" id="choice-text" placeholder="選択肢">
                    </div>
                    <div class="choice">
                        <input type="radio" id="2">
                        <input type="text" id="choice-text">
                    </div>
                    <div class="choice">
                        <input type="radio" id="3">
                        <input type="text" id="choice-text">
                    </div>
                    <div class="choice">
                        <input type="radio" id="4">
                        <input type="text" id="choice-text">
                    </div>
                </fieldset>
            </div>
            <div id="submit-quiz-btn">
                <i></i>
            </div>
        </div>
    </div>

    <div id="post-roading" class="post-roading-back">
        <h1 class="post-roading-msg">問題を投稿しています</h1>
        <div class="post-roading-anime"></div>
    </div>

    <!-- 作問確認ポップアップ -->
    <div id="metadata-modal-back">
        <span id="metadata-close-btn"></span>
        <div id="metadata-modal">
            <h5>以下の内容で投稿します</h5>
            <div id="quiz-metadata">
                    <input type="text" id="post-title" placeholder="タイトル">
                    <select id="post-genres">
                    </select>
                    <input type="text" id="post-explanation" placeholder="説明">
            </div>
            <div>
                <button id="cancel-quiz-btn"><i></i> 修正</button>
                <button id="post-quiz-btn"><i></i> 投稿</button>
            </div>
        </div>
    </div>
    
    <script src="js/index.js"></script>
    <script src="js/createQuiz.js"></script>
</body>

</html>
