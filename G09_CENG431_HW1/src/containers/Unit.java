package containers;

import java.util.ArrayList;
import java.util.List;
import random.*;

public class Unit {

	private List<Quiz> quizzes = new ArrayList<Quiz>(); // adding generics
	private RandomNumberGenerator random = new RandomNumberGenerator();
	
	
	public Unit() {
		this.createQuizzes(1,10);
	}

	private void createQuizzes(int min, int max) {
		
	    int unitNum  = this.random.generateInt(min, max);
	    for (int i=0; i<unitNum; i++) {
	    	this.quizzes.add(new Quiz());
	    	 
	    }
	}
	
	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public Quiz getQuizByNumber(int index) {
		return quizzes.get(index);
		
	}
	public int getQuizNumber() {
		return this.quizzes.size();
	}
	
	
}
