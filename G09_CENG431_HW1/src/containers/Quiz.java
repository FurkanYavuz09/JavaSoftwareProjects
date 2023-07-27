package containers;

import java.util.ArrayList;

import questions.*;

public class Quiz {

	private QuestionsCreator questionCreator;
	
	public ArrayList<Question> getQuestions() {
		return this.questionCreator.getQuestions();
	}

	public Quiz() {
		this.questionCreator = new QuestionsCreator();
		
		
	}
	
	public String getQuestionTypes() {
		return questionCreator.typeNumsToString();
	}
	
	public int getNumOfQuestions() {
		return questionCreator.getQuestionNumber();
		
	}

	
	
	
	
}
