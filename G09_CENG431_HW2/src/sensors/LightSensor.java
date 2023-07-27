package sensors;




public class LightSensor extends Sensor {
   
    private String type;
    private int lightStatus;

    public LightSensor(int lightStatus) {
        this.lightStatus = lightStatus;
        this.type = "light";
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int sendReading() {
    	if (this.lightStatus==1) {
    		System.out.println("Light is detected On by Light Sensor.");
    	}
    	else if(this.lightStatus==0) {
    		System.out.println("Light is detected Off by Light Sensor.");
    	}
    	else {
    		System.out.println("Error detected on the system.");
    	}
        return this.lightStatus;
       
    }

	public void setLightStatus(int lightStatus) {
		this.lightStatus = lightStatus;
	}
    
    

	
}
