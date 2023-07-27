package actuators;



public class Thermostat extends Actuator {
    
    private String type;

    public Thermostat() {
       
        this.type = "thermostat";
    }

    @Override
    public String getActuatorType() {
        return type;
    }

	@Override
	public void executeCommand(int value) {
		// automatic control by the mediator
		if (value>0) {
			System.out.println("Temperature decreased "+Integer.toString(value)+" degree by Thermostat." );
		}
		else if (value<0){
			System.out.println("Temperature increased "+Integer.toString(-value)+" degree by Thermostat." );
		}
		
		
	}

}
