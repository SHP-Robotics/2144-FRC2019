/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2144.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import frc.team2144.Robot;
import frc.team2144.Constants;
import frc.team2144.commands.ElevatorDrive;

public class NineteenClimb extends Command {
  public NineteenClimb() {
    requires(Robot.m_scissor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_scissor.driveScissorLift(Constants.LIFT_POWER);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.m_scissor.limitSwitchPressed())
      return true;
    else
      return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_scissor.driveScissorLift(Constants.NO_POWER);
    Scheduler.getInstance().add(new ElevatorDrive(Constants.CLIMBER));
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
