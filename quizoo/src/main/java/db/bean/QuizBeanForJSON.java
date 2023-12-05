package db.bean;

import java.util.List;

public class QuizBeanForJSON {
    private String title;
    private int genreNo;
    private String explanation;
    private List<QuestionBeanForJSON> questions;
    

	private int quizId;
	private int authorNo;
	private int questionCount;
	private String createTime;
	private float correctRate;
	private int totalParticipants;

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

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(int authorNo) {
		this.authorNo = authorNo;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public float getCorrectRate() {
		return correctRate;
	}

	public void setCorrectRate(float correctRate) {
		this.correctRate = correctRate;
	}

	public int getTotalParticipants() {
		return totalParticipants;
	}

	public void setTotalParticipants(int totalParticipants) {
		this.totalParticipants = totalParticipants;
	}
}
