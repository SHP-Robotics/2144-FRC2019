/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;

public class IntakeDrive extends Command {

  public IntakeDrive() {
    requires(Robot.m_intake); // declare subsystem dependencies
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.leftTriggerPressed()) // switched
      Robot.m_intake.driveIntake(Constants.FULL_FORWARD_POWER);
    else if(Robot.m_oi.rightTriggerPressed()) // switched
      Robot.m_intake.driveIntake(Constants.FULL_REVERSE_POWER);
    else
      Robot.m_intake.driveIntake(Constants.NO_POWER);
    // if(Robot.m_oi.rightLowPressed()) {
    //   Robot.m_intake.flipIntake(Constants.INTAKE_UP);
    // }
    // else if(Robot.m_oi.rightHighPressed()) {
    //   Robot.m_intake.flipIntake(Constants.INTAKE_DOWN);
    // }
    if(Robot.m_oi.rightHighPressed())
      Robot.m_intake.driveFlip(Constants.FULL_FORWARD_POWER); // Down
    else if(Robot.m_oi.rightLowPressed())
      Robot.m_intake.driveFlip(Constants.FULL_REVERSE_POWER); // Up
    else
      Robot.m_intake.driveFlip(Constants.NO_POWER);
    // SmartDashboard.putString("Flip Encoder", ""+(Robot.m_intake.getFlipEncoderVal()));
    }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
