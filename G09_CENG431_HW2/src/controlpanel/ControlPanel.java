package controlpanel;

import random.*;



public class ControlPanel  {
	
	private RandomNumberGenerator random= new RandomNumberGenerator();
	private int currentTemperature ;
	private int healthyMinTemperature = 20;
	private int healthyMaxTemperature =25;
	
    public ControlPanel(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public int sendTempCommand() {
    	int changeAmount = 0;
    	if (currentTemperature>25) {
    		changeAmount = random.generateInt(currentTemperature-healthyMaxTemperature, currentTemperature-healthyMinTemperature);
    		System.out.println("Temperature will be decreased "+Integer.toString(changeAmount)+" degrees by Control Panel.");
    	}
    	else if ( currentTemperature<20) {
    		changeAmount = random.generateInt(currentTemperature-healthyMaxTemperature, currentTemperature-healthyMinTemperature);
    		System.out.println("Temperature will be increased "+Integer.toString(-changeAmount)+" degrees by Control Panel.");
    	}
    	else {
    		System.out.println("Temperature is already in between the healthy boundaries. It will not change !!!");
    	}
    	return changeAmount;
    	
    }
    
    public int sendLightCommand() {
    	int command = random.generateInt(0, 2);
    	if (command==1) {
    		
    		System.out.println("Control Panel sending light On command");
    	}
    	else if(command==0) {
    		System.out.println("Control Panel sending light Off command");
    	}
    	return command;
    }
    
   
	public int sendDoorCommand() {
		int command = random.generateInt(0, 2);
    	if (command==1) {
    		
    		System.out.println("Control Panel sending Lock Door command");
    	}
    	else if(command==0) {
    		System.out.println("Control Panel sending Unlock Door command");
    	}
    	return command;
    }
    
    public int getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(int currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
	
}
