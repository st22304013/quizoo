package db.bean;

import java.io.Serializable;

public class QuestionBean implements Serializable {
	private int quizId;
	private int questionId;
	private String question;
	private String choice_1;
	private String choice_2;
	private String choice_3;
	private String choice_4;
	private boolean[] judge;
	
	
	public QuestionBean() {}
	
	public QuestionBean(int quiz_id,int question_id, String question, String choice_1,String choice_2,String choice_3
						,String choice_4,boolean[] judge) {
		this.quizId=quiz_id;
		this.questionId=question_id;
		this.question = question;
		this.choice_1=choice_1;
		this.choice_2=choice_2;
		this.choice_3=choice_3;
		this.choice_4=choice_4;
		this.judge=judge;
	}

	public int getQuiz_id() {
		return quizId;
	}

	public void setQuiz_id(int quiz_id) {
		this.quizId = quiz_id;
	}

	public int getQuestion_id() {
		return questionId;
	}

	public void setQuestion_id(int question_id) {
		this.questionId = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoice_1() {
		return choice_1;
	}

	public void setChoice_1(String choice_1) {
		this.choice_1 = choice_1;
	}

	public String getChoice_2() {
		return choice_2;
	}

	public void setChoice_2(String choice_2) {
		this.choice_2 = choice_2;
	}

	public String getChoice_3() {
		return choice_3;
	}

	public void setChoice_3(String choice_3) {
		this.choice_3 = choice_3;
	}

	public String getChoice_4() {
		return choice_4;
	}

	public void setChoice_4(String choice_4) {
		this.choice_4 = choice_4;
	}

	public boolean[] getJudge() {
		return judge;
	}

	public void setJudge(boolean[] judge) {
		this.judge = judge;
	}
	

}
