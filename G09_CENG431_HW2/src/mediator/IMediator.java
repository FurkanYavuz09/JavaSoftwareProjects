package mediator;

import sensors.*;
import actuators.*;
import controlpanel.*;

public interface IMediator {
	
    public void registerSensor(Sensor sensor);
    
    public void registerActuator(Actuator actuator);
    
    public void registerControlPanel(ControlPanel controlPanel);
    
    public void sendCommand();
}
