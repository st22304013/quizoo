package db.bean;

public class QuestionBeanForJSON {
    private String question;
    private String choise1;
    private String choise2;
    private String choise3;
    private String choise4;
    private boolean[] judge;

    // コンストラクタ、ゲッター、セッターなどを追加する

    // 問題文
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // 回答1
    public String getChoise1() {
        return choise1;
    }

    public void setChoise1(String choise1) {
        this.choise1 = choise1;
    }

    // 正解
    public String getChoise2() {
        return choise2;
    }

    public void setChoise2(String choise2) {
        this.choise2 = choise2;
    }

    // 回答2
    public String getChoise3() {
        return choise3;
    }

    public void setChoise3(String choise3) {
        this.choise3 = choise3;
    }

    // 回答3
    public String getChoise4() {
        return choise4;
    }

    public void setChoise4(String choise4) {
        this.choise4 = choise4;
    }

    // 正解の判定
    public boolean[] getJudge() {
        return judge;
    }

    public void setJudge(boolean[] judge) {
        this.judge = judge;
    }
}