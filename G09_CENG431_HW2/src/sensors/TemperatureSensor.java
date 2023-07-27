package sensors;



public class TemperatureSensor extends Sensor {
    
    private String type;
    private int readTemperature;

    

	public TemperatureSensor(int temperature) {
    	
        this.readTemperature = temperature;
        this.type = "temperature";
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int sendReading() {
    	System.out.println("Temperature read "+ Integer.toString(readTemperature)+" degrees by Temperature Sensor.");
       return this.readTemperature;
        
    }
    
    public int getReadTemperature() {
		return readTemperature;
	}

	public void setReadTemperature(int readTemperature) {
		this.readTemperature = readTemperature;
	}
}