package sensors;

import random.RandomNumberGenerator;

public abstract class Sensor {

	public RandomNumberGenerator random = new RandomNumberGenerator() ;
	
	public Sensor() {
		
	}
	
	
	public abstract int sendReading();

	public abstract String getType();
		
	
	
	
	
}
