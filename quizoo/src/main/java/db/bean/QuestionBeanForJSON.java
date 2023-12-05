package db.bean;

public class QuestionBeanForJSON {
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private boolean[] judge;

	private int quizId;

    // コンストラクタ、ゲッター、セッターなどを追加する

    // 問題文
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

    // 正解の判定
    public boolean[] getJudge() {
        return judge;
    }

    public void setJudge(boolean[] judge) {
        this.judge = judge;
    }

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

}