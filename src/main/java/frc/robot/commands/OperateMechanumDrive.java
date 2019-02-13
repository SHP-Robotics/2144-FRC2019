package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

public class OperateMechanumDrive extends CommandBase {
    
  public OperateMechanumDrive() {
    requires(drivebase);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    drivebase.reset_encoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double x = oi.getRightJoyX();
    double y = -(oi.getLeftJoyY() + oi.getRightJoyY()) /2;
    double rot = (oi.getLeftJoyY() - oi.getRightJoyY()) /2;
    drivebase.mecanumCartesian(x, y, rot);
    drivebase.updateEncoderData();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    drivebase.mecanumCartesian(0, 0, 0, 0);
    navsensor.resetAngle();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    super.interrupted();
  }
}