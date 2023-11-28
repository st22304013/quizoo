package db.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizQuestionBean implements Serializable {
	public QuizBean quiz;
	public ArrayList<QuestionBean> question;
	
	public QuizQuestionBean() {}
	
	public QuizQuestionBean(QuizBean quiz,ArrayList<QuestionBean> question) {
		this.quiz=quiz;
		this.question=question;
	}

	public QuizBean getQuiz() {
		return quiz;
	}

	public void setQuiz(QuizBean quiz) {
		this.quiz = quiz;
	}

	public ArrayList<QuestionBean> getQuestion() {
		return question;
	}

	public void setQuestion(ArrayList<QuestionBean> question) {
		this.question = question;
	}
	
}
