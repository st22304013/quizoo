package db.bean;

import java.util.List;

public class QuizBeanForJSON {
    private String title;
    private int genreNo;
    private String explanation;
    private List<QuestionBeanForJSON> questions;

    // コンストラクタ、ゲッター、セッターなどを追加する

    // タイトル
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // ジャンル番号
    public int getGenreNo() {
        return genreNo;
    }

    public void setGenreNo(int genreNo) {
        this.genreNo = genreNo;
    }

    // 問題の説明
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    // 問題のリスト
    public List<QuestionBeanForJSON> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionBeanForJSON> questions) {
        this.questions = questions;
    }
}
