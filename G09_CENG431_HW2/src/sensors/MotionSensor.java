package sensors;


public class MotionSensor extends Sensor {
   
    private String type;
    private int lockStatus;


	public MotionSensor(int lockStatus) {
        this.lockStatus = lockStatus;
        this.type = "motion";
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int sendReading() {
    	if (this.lockStatus==1) {
    		System.out.println("Door is detected locked  by Motion Sensor.");
    	}
    	else if(this.lockStatus==0) {
    		System.out.println("Door is detected not locked  by Motion Sensor.");
    	}
    	
        return this.lockStatus;
       
    }
    
    public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}
}
