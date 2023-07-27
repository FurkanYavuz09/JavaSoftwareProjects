package actuators;


public class DoorLock extends Actuator {
    
    private String type;

    public DoorLock() {
     
        this.type = "DoorLock";
    }

    
    public String getActuatorType() {
        return this.type;
    }


	@Override
	public void executeCommand(int value) {
		super.setDoorLock(value);
		if (value==1) {
			System.out.println("Door is locked Mission Succesful. " );
		}
		else if (value==0){
			System.out.println("Door is unlocked Mission Succesful." );
		}
		
	}

    
}