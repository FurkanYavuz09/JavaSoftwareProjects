package questions;

import random.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class QuestionsCreator {

	private QuestionTypes[] types = QuestionTypes.values();
	
	private RandomNumberGenerator random= new RandomNumberGenerator();
	
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	private int[] typeNums = new int[this.types.length];
	
	public QuestionsCreator() {
		
		this.createQuestions();
	}
	
	

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	private void createQuestions() {
		
		int n = random.generateInt(8, 15);
		for (int i=0; i<n; i++) {
			int questionType = random.generateInt(0, this.types.length);
		    
		    if (this.types[questionType] == QuestionTypes.READING) {
		    	this.questions.add(createReading());
		    	this.typeNums[0]+=1;
		    }
		    else if (this.types[questionType] == QuestionTypes.LISTENING) {
		    	this.questions.add(createListening());
		    	this.typeNums[1]+=1;
		    }
		    else if (this.types[questionType] == QuestionTypes.SPEAKING) {
		    	this.questions.add(createSpeaking());
		    	this.typeNums[2]+=1;
		    }
		    else {
		    	this.questions.add(createWordMatching());
		    	this.typeNums[3]+=1;
		    }
		}
	}
	public String typeNumsToString() {
		String st = "";
		String[] typeInitials = {"R","L","S","W"};
		for (int i=0; i<this.types.length; i++) {
			if (this.typeNums[i]>0) {
				st+= Integer.toString(this.typeNums[i])+typeInitials[i]+":";
			}
		}
		return st.substring(0, st.length()-1);
		
		
	}
	private Question createReading() {
		String englishString = createQuestionString(random.generateInt(5, 100));
		String translatedString = createQuestionString(random.generateInt(5, 100));
		Question readingQuestion = new Reading(englishString, translatedString);
		return readingQuestion;
	}
	
	private Question createListening() {
		String chosenLanguageString = createQuestionString(random.generateInt(5, 100));
		int audio = createAudio(60, 300);
		Question listeningQuestion = new Listening(chosenLanguageString, audio);
		return listeningQuestion;
	}
	private Question createSpeaking() {
		int audio1 = createAudio(60, 300);
		int audio2 = createAudio(60, 300);
		Question listeningQuestion = new Speaking(audio1, audio2);
		return listeningQuestion;
	}
	private Question createWordMatching() {
		int numOfKeyValue = random.generateInt(4, 8);
		Dictionary<String, String> dictionary = new Hashtable<>();
		
		for (int i=0; i<numOfKeyValue; i++) {
			String key = createQuestionString(random.generateInt(5, 100));
			String value = createQuestionString(random.generateInt(5, 100));
			dictionary.put(key, value);
		}
		
		Question wordMatchingQuestion = new WordMatching(dictionary);
		return wordMatchingQuestion;
	}
	

	// using Math.random() method
	private String createQuestionString(int n)
	{

		// choose a Character random from this String
		String AlphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
	
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
	
		for (int i = 0; i < n; i++) {
	
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int)(AlphabeticString.length() * random.generateFloat());
		
			// add Character one by one in end of sb
			sb.append(AlphabeticString.charAt(index));
		}
	
		return sb.toString();
	}
	
	private int createAudio(int min, int max) {
		return random.generateInt(min, max);
	}
	
	public int getQuestionNumber() {
		return this.questions.size();
		
	}
	

	
	

}
