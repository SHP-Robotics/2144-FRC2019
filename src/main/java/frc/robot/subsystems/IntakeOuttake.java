/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.IntakeDrive;
import frc.robot.RobotMap;

/**
 * This subsystem will drive the intake and outtake wheels. It will be used for delivering balls and disks,
 *  and during the climbing process. It might have to power servos at some point.
 */
public class IntakeOuttake extends Subsystem {

  private CANSparkMax intake;

  public IntakeOuttake() {
    intake = new CANSparkMax(RobotMap.INTAKE_DRIVE, MotorType.kBrushed);
  }
  
  public void driveIntake(double speed) {
    intake.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeDrive()); // IntakeDrive runs whenever this subsystem is inactive.
  }
}
