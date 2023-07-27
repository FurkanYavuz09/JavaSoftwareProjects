package random;

import java.util.Random;

public class RandomNumberGenerator {

	private Random random;
	
	public RandomNumberGenerator() {
		this.random = new Random();
		
	}
	
	public int generateInt(int min, int max) {
		
	    int RandomNumber  = this.random.nextInt(max - min) + min;
	    return RandomNumber;
		
	}
	
}