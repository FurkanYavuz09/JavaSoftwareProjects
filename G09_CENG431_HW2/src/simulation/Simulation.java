package simulation;

import mediator.*;
import sensors.*;
import actuators.*;
import controlpanel.*;
import random.*;
import java.util.concurrent.TimeUnit;

public class Simulation {
    
	public Simulation() {
		
	}
	
    public void  simulate( int n) throws InterruptedException {
    	
    	
    	RandomNumberGenerator random = new RandomNumberGenerator() ;
        // create mediator
        Mediator mediator = new Mediator();
        
        
        
        // create sensors
        Sensor temperatureSensor = new TemperatureSensor(random.generateInt(1, 40));
        mediator.registerSensor(temperatureSensor);
        
        
        Sensor lightSensor = new LightSensor(random.generateInt(0, 2));
        mediator.registerSensor(lightSensor);
        
        Sensor motionSensor = new MotionSensor(random.generateInt(0, 2));
        mediator.registerSensor(motionSensor);
        
        // create actuators
        Actuator thermostat = new Thermostat();
        mediator.registerActuator(thermostat);
        
        Actuator lightBulb = new LightBulb();
        mediator.registerActuator(lightBulb);
        
        Actuator doorLock = new DoorLock();
        mediator.registerActuator(doorLock);
        
        // create control panel
        ControlPanel controlPanel = new ControlPanel(random.generateInt(0, 40));
        mediator.registerControlPanel(controlPanel);
        
        // run simulation for n seconds
        for (int i = 0; i < n; i++) {
            // simulate sensors sending readings
        	mediator.sendCommand(); 
        	System.out.println("");
        	// wait for 1 second
        	TimeUnit.SECONDS.sleep(1);
            
            
        }
    }
}