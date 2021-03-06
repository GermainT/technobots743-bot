/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

import org.usfirst.frc.team743.robot.commands.CloseClaw;
import org.usfirst.frc.team743.robot.commands.ExtendBigActuator;
import org.usfirst.frc.team743.robot.commands.ExtendBigPneumatic;
import org.usfirst.frc.team743.robot.commands.ExtendSmallActuator;
import org.usfirst.frc.team743.robot.commands.ExtendSmallPneumatic;
import org.usfirst.frc.team743.robot.commands.OpenClaw;
import org.usfirst.frc.team743.robot.commands.PneumaticToggleCommand;
import org.usfirst.frc.team743.robot.commands.RetractBigActuator;
import org.usfirst.frc.team743.robot.commands.RetractBigPneumatic;
import org.usfirst.frc.team743.robot.commands.RetractSmallActuator;
import org.usfirst.frc.team743.robot.commands.RetractSmallPneumatic;
import org.usfirst.frc.team743.robot.commands.StopBigActuator;
import org.usfirst.frc.team743.robot.commands.StopSmallActuator;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public final int X = 2;
	public final int A = 3;
	public final int B = 1;
	public final int Y = 4;

	public final int LB = 5;
	public final int RB = 6;
	public final int LT = 7;
	public final int RT = 8;
	
	public final int SELECT = 9;
	public final int START = 10;

	public final int stickLeftButton = 11;
	public final int stickRightButton = 12;
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	XboxController _xboxController = new XboxController(0);
	
	Button buttonA = new JoystickButton(_xboxController, A);
	Button buttonB = new JoystickButton(_xboxController, B);
	Button buttonX = new JoystickButton(_xboxController, X);
	Button buttonY = new JoystickButton(_xboxController, Y);
	Button buttonSTART = new JoystickButton(_xboxController, START);
	Button buttonSELECT = new JoystickButton(_xboxController, SELECT);
	Button buttonLB = new JoystickButton(_xboxController, LB);
	Button buttonRB = new JoystickButton(_xboxController, RB);
	Button buttonLT = new JoystickButton(_xboxController, LT);
	Button buttonRT = new JoystickButton(_xboxController, RT);
	Button buttonStickLeft = new JoystickButton(_xboxController, stickLeftButton);
	Button buttonStickRight = new JoystickButton(_xboxController, stickRightButton);
	
	public OI(){
		
		buttonRT.whileHeld(new ExtendBigActuator());
		buttonRT.whenReleased(new StopBigActuator());
		buttonRB.whileHeld(new RetractBigActuator());
		buttonRB.whenReleased(new StopBigActuator());
		
		buttonLT.whileHeld(new ExtendSmallActuator());
		buttonLT.whenReleased(new StopSmallActuator());
		buttonLB.whileHeld(new RetractSmallActuator());
		buttonLB.whenReleased(new StopSmallActuator());
		
		buttonX.whenPressed(new PneumaticToggleCommand(new OpenClaw(), new CloseClaw()));
		
		buttonA.whileHeld(new PneumaticToggleCommand(new ExtendBigPneumatic(), new RetractBigPneumatic()));
		
		buttonY.whileHeld(new PneumaticToggleCommand(new ExtendSmallPneumatic(), new RetractSmallPneumatic()));
	}
		

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
	
