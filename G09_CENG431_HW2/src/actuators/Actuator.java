package actuators;


public abstract class Actuator {

	
	private int light;
	private int doorLock;
	
	public Actuator() {
		
		
	}
	
	public abstract  String getActuatorType();
	
	public abstract void executeCommand(int value);

	public int getDoorLock() {
		return doorLock;
	}

	public int getLight() {
		return light;
	}
	
	public void setLight(int light) {
		this.light = light;
	}

	public void setDoorLock(int doorLock) {
		this.doorLock = doorLock;
	}
	
}
