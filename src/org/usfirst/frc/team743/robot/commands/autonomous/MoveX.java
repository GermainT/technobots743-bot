package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class MoveX extends TimedCommand {

	private double _speed;
	
    public MoveX(double timeout, double speed) {
        super(timeout);
        this._speed = speed;
        requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveX = this._speed;
    }

    // Called once after timeout
    protected void end() {
    	Robot.driveX = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveX = 0;
    }
}
