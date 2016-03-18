
package org.usfirst.frc.team6130.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//public static final armMover armMoverSub = new armMover();
	
	Joystick driver;
	Joystick operator;
	Victor leftDrive;
	Victor rightDrive;
	Victor leftDrive2;
	Victor rightDrive2;
	Victor armDrive;
	
	
	
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//All left drive taped in red
    	//All right drive taped in green
    	//Arm is always in PWM 4
    	operator = new Joystick(1);
    	driver = new Joystick(0);
    	leftDrive = new Victor(0);
    	rightDrive = new Victor(1);
    	leftDrive2 = new Victor(2);
    	rightDrive2 = new Victor(3);
    	armDrive = new Victor(4);
    	
    	
    	
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//Default settings for driving straight under low bar
    	leftDrive.set(.6);
    	rightDrive.set(-6);
    	leftDrive2.set(.6);
    	rightDrive2.set(-6);
    	Timer.delay(4);
    	leftDrive.set(0);
    	rightDrive.set(0);
    	leftDrive2.set(0);
    	rightDrive2.set(0);
    	/*switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}*/
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	
        leftDrive.set(driver.getRawAxis(1));
        leftDrive2.set(driver.getRawAxis(1));
        rightDrive.set(-driver.getRawAxis(5));
        rightDrive2.set(-driver.getRawAxis(5));
        armDrive.set(-operator.getRawAxis(1));
        /*if(operator.getRawButton(5)){
        	armMoverSub.open();
        }else if(operator.getRawButton(6)){
        	armMoverSub.close();
        }else if(operator.getRawButton(1)){
        	armMoverSub.stop();
        }
        */
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
