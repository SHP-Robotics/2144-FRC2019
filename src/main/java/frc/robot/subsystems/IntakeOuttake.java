/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.commands.IntakeDrive;
import frc.robot.Constants;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakeOuttake extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  private CANSparkMax intake;
  private CANSparkMax intakeFlip;
  private CANEncoder flipEncoder;

  public IntakeOuttake() {
    // Intert a subsystem name and PID values here
    super("IntakeOuttake", Constants.INTAKE_P, Constants.INTAKE_I, Constants.INTAKE_D);
    intake = new CANSparkMax(RobotMap.INTAKE_DRIVE, MotorType.kBrushed);
    intakeFlip = new CANSparkMax(RobotMap.INTAKE_FLIP, MotorType.kBrushed);
    flipEncoder = new CANEncoder(intakeFlip);
    flipEncoder.setPosition(0.0);
    this.enable();
  }

  public void driveIntake(double speed) {
    intake.set(speed);
  }

  public void flipIntake(double setpoint) {
    this.setSetpoint(setpoint);
  }

  public void driveFlip(double speed) {
    intakeFlip.set(speed);
  }

  public double getFlipEncoderVal() {
    return flipEncoder.getPosition();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeDrive());
  }

  @Override
  protected double returnPIDInput() {
    return flipEncoder.getPosition()/* / Constants.MAX_FLIP_ENCODER*/;
  }

  @Override
  protected void usePIDOutput(double output) {
    // intakeFlip.set(output);
  }
}
