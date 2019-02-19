/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.GatorDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {

  private CANSparkMax fl;
  private CANSparkMax fr;
  private CANSparkMax bl;
  private CANSparkMax br;
  private MecanumDrive drive;

  public Drivetrain() {
    fl = new CANSparkMax(RobotMap.FL_DRIVE, MotorType.kBrushless);
    fr = new CANSparkMax(RobotMap.FR_DRIVE, MotorType.kBrushless);
    bl = new CANSparkMax(RobotMap.BL_DRIVE, MotorType.kBrushless);
    br = new CANSparkMax(RobotMap.BR_DRIVE, MotorType.kBrushless);
    drive = new MecanumDrive(fl, bl, fr, br);
  }

  /**
   * @param x   How fast to move sideways. Positive for right.
   * @param y   How fast to move forward. Positive forward.
   * @param rot How fast to turn. Positive right.
   */
    public void mecanumCartesian(double x, double y, double rot) {
      drive.driveCartesian(x, y, rot);
  }

  /**
   * @param x   How fast to move sideways. Positive for right.
   * @param y   How fast to move forward. Positive forward.
   * @param rot How fast to turn. Positive right.
   */
  public void mecanumCartesian(double x, double y, double rot, double gyro) {
      drive.driveCartesian(x, y, rot, gyro);
  }

  /**
   * Stops all drive motors.
   */
  public void stop() {
      drive.driveCartesian(0, 0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new GatorDrive());
  }
}
