package questions;

public class Reading extends Question {

	private String englishString;
	private String translatedString;
	
	public Reading(String englishString, String translatedString) {
		super(QuestionTypes.READING, 10);
		// TODO Auto-generated constructor stub
		this.setEnglishString(englishString);
		this.setTranslatedString(translatedString);
	}

	public String getTranslatedString() {
		return translatedString;
	}

	public void setTranslatedString(String translatedString) {
		this.translatedString = translatedString;
	}

	public String getEnglishString() {
		return englishString;
	}

	public void setEnglishString(String englishString) {
		this.englishString = englishString;
	}

	@Override
	public void getContent() {
		// TODO Auto-generated method stub
		System.out.println("english : "+englishString);
		System.out.println(translatedString);
	}

}
