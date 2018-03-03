package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenClaw extends InstantCommand {

    public OpenClaw() {
        requires(Robot.clawMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.clawMechanism.openClaw();
    	System.out.println("Claw - OPENING");
    }
}
