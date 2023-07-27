package questions;

public class Speaking extends Question{

	private int audio1;
	private int audio2;
	
	public Speaking(int audio1, int audio2) {
		super(QuestionTypes.SPEAKING, 8);
		this.audio1 = audio1;
		this.audio2 = audio2;
	}

	public int getAudio2() {
		return audio2;
	}

	public void setAudio2(int audio2) {
		this.audio2 = audio2;
	}

	public int getAudio1() {
		return audio1;
	}

	public void setAudio1(int audio1) {
		this.audio1 = audio1;
	}
	
	@Override
	public void getContent() {
		// TODO Auto-generated method stub
		System.out.println("audio1 : "+audio1);
		System.out.println("audio2 : "+audio2);
	}
	
	
}
