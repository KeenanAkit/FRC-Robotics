package org.usfirst.frc.team6130.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6130.robot.*;
/**
 *
 */
public class armMover extends Subsystem {
    int motorChannel = 4;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor armDriver = new Victor(motorChannel);
	
	public void open(){
		armDriver.set(0.4);
	}
	public void close(){
		armDriver.set(-1);
	}
	public void stop(){
		armDriver.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

