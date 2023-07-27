package questions;

import java.util.Dictionary;


public class WordMatching extends Question{

	Dictionary<String, String> dictionary;
	public WordMatching(Dictionary<String, String> dictionary) {
		super(QuestionTypes.WORDMATCHING, 5);
		this.dictionary = dictionary;
	}
	
	@Override
	public void getContent() {
		// TODO Auto-generated method stub
		
	}
}
