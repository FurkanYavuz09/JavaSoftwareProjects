package mediator;


import java.util.ArrayList;
import java.util.List;
import sensors.*;
import actuators.*;
import controlpanel.*;
import random.RandomNumberGenerator;


public  class Mediator implements IMediator {

	 	private List<Sensor> sensors = new ArrayList<>();
	    private List<Actuator> actuators = new ArrayList<>();
	    private ControlPanel controlPanel;
	    private RandomNumberGenerator random = new RandomNumberGenerator() ;
	    
	    public Mediator() {
	    	
	    }
	    
	    public void registerSensor(Sensor sensor) {
	        sensors.add(sensor);
	        
	    }

	    
	    public void registerActuator(Actuator actuator) {
	        actuators.add(actuator);
	       
	    }
	    
	    public void registerControlPanel(ControlPanel controlPanel) {
	        this.controlPanel = controlPanel;
	        
	    }

	   
	    
	    public void sendCommand() {
	    	for (int i=0; i<this.sensors.size(); i++) {
	    		
	    		if (this.sensors.get(i).getType().equals("temperature") ){
	    			int sensorReading = this.sensors.get(i).sendReading();
	    			controlPanel.setCurrentTemperature(sensorReading);
	    			int command = controlPanel.sendTempCommand();
	    			for (int j=0; j< actuators.size(); j++) {
	    				if (actuators.get(j).getActuatorType().equals("thermostat")) {
	    					actuators.get(j).executeCommand(command);
	    					
	    				}
	    			}
	    			((TemperatureSensor) this.sensors.get(i)).setReadTemperature(random.generateInt(1, 40));
	    		}
	    		else if(this.sensors.get(i).getType().equals("light")) {
	    			int sensorReading = this.sensors.get(i).sendReading();
	    			
	    			int command = controlPanel.sendLightCommand();
	    			if (sensorReading==command && command==1) {
	    				System.out.println("There will be no change light is already on ");
	    				continue;
	    			}
	    			else if (sensorReading==command && command==0) {
	    				System.out.println("There will be no change light is already off ");
	    				continue;
	    				
	    			}
	    			for (int j=0; j< actuators.size(); j++) {
	    				if (actuators.get(j).getActuatorType().equals("LightBulb")) {
	    					actuators.get(j).executeCommand(command);
	    					((LightSensor) this.sensors.get(i)).setLightStatus(actuators.get(j).getLight());
	    				}
	    			}
	    			
	    		}
	    		else if (this.sensors.get(i).getType().equals("motion")) {
	    			int sensorReading = this.sensors.get(i).sendReading();
	    			
	    			int command = controlPanel.sendDoorCommand();
	    			
	    			if (sensorReading==command && command==1) {
	    				System.out.println("There will be no change door is already locked ");
	    				continue;
	    			}
	    			else if (sensorReading==command && command==0) {
	    				System.out.println("There will be no change door is already unlocked ");
	    				continue;
	    				
	    			}
	    			
	    			for (int j=0; j< actuators.size(); j++) {
	    				if (actuators.get(j).getActuatorType().equals("DoorLock")) {
	    					actuators.get(j).executeCommand(command);
	    					((MotionSensor) this.sensors.get(i)).setLockStatus(actuators.get(j).getDoorLock());
	    				}
	    			}
	    			
	    			
	    		}
	    	}
	    	
	    }
	    
	   
}
		