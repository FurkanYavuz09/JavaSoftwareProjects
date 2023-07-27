package user;

public class User {
	
	private String username;
	private String password;
	

	private int numOfStreak;
	private String chosenLanguage;
	private int totalPoint = 0;
	private String rank = "Bronze";
	private int quizNumberToSolve;
	private int currentUnit;
	
	public User(String username, String password) {
		this.username = username; 
		this.password = password;
		
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getCurrentUnit() {
		return currentUnit;
	}

	public void setCurrentUnit(int currentUnit) {
		this.currentUnit = currentUnit;
	}
	
	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getNumOfQuizzesToTake() {
		return quizNumberToSolve;
	}

	public void setNumOfQuizzesToTake(int quizNumberToSolve) {
		this.quizNumberToSolve = quizNumberToSolve;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getChosenLanguage() {
		return chosenLanguage;
	}

	public void setChosenLanguage(String chosenLanguage) {
		this.chosenLanguage = chosenLanguage;
	}
	
	public int getNumOfStreak() {
		return numOfStreak;
	}

	public void setNumOfStreak(int numOfStreak) {
		this.numOfStreak = numOfStreak;
	}

	public String getUsername() {
		return username;
	}

	
	
	
	
	
	


	
}
