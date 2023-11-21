package db.bean;

import java.io.Serializable;

public class AnswerhistoryBean implements Serializable{
	private int quizId;
	private String answeredTime;
	private int questionCount;
	private int correctCount;
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AnswerhistoryBean() {}
	
	public AnswerhistoryBean(int quizId, String answeredTime, int questionCount, int correctCount, String title) {
		this.quizId = quizId;
		this.answeredTime = answeredTime;
		this.questionCount = questionCount;
		this.correctCount = correctCount;
		this.title = title;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getAnsweredTime() {
		return answeredTime;
	}

	public void setAnsweredTime(String answeredTime) {
		this.answeredTime = answeredTime;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public int getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}
	
	
}
