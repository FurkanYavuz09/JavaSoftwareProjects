package questions;

public abstract class Question {

	private int point;
	private QuestionTypes type;
	
	
	public Question(QuestionTypes type, int point) {
		this.point = point;
		this.type = type;
		
	}


	public int getPoint() {
		return point;
	}


	public QuestionTypes getType() {
		return type;
	}
	
	public abstract void getContent();
	
}
