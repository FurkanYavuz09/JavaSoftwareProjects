package actuators;



public class LightBulb extends Actuator {
    
    private String type;

    public LightBulb() {
        
        this.type = "LightBulb";
    }

    @Override
    public String getActuatorType() {
        return type;
    }

    @Override
    public void executeCommand(int value) {
    	this.setLight(value);
    	if (value==1) {
			System.out.println("Light is Opened by LightBulb Actuator" );
		}
		else if(value==0){
			System.out.println("Light is Closed by LightBulb Actuator" );
		}
        
    }
}