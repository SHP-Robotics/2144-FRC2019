/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2144.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2144.Robot;

public class GatorDrive extends Command {
  public GatorDrive() {
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double x = (Robot.m_oi.get_right_x() + Robot.m_oi.get_left_x()) / 2;
    double y = -(Robot.m_oi.get_left_y() + Robot.m_oi.get_right_y()) / 2;
    double rot = (Robot.m_oi.get_left_y() - Robot.m_oi.get_right_y()) / 2;
    Robot.m_drivetrain.mecanumCartesian(x, y, rot); // tankanum drive
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
