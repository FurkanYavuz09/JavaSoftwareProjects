package questions;

public class Listening extends Question{

	private int audio;
	private String chosenLanguageString;
	
	public Listening(String chosenLanguageString, int audio) {
		super(QuestionTypes.LISTENING, 7);
		// TODO Auto-generated constructor stub
		setAudio(audio);
		setChosenLanguageString(chosenLanguageString);
	}

	public int getAudio() {
		return audio;
	}

	public void setAudio(int audio) {
		this.audio = audio;
	}

	public String getChosenLanguageString() {
		return chosenLanguageString;
	}

	public void setChosenLanguageString(String chosenLanguageString) {
		this.chosenLanguageString = chosenLanguageString;
	}
	
	@Override
	public void getContent() {
		// TODO Auto-generated method stub
		System.out.println("audio : "+audio);
		System.out.println(chosenLanguageString);
	}
}
