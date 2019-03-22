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
import frc.robot.commands.TankDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TankDrivetrain extends Subsystem {

  private CANSparkMax fl;
  private CANSparkMax fr;
  private CANSparkMax bl;
  private CANSparkMax br;
  private MecanumDrive drive;

  public TankDrivetrain() {
    fl = new CANSparkMax(RobotMap.FL_DRIVE, MotorType.kBrushless);
    fr = new CANSparkMax(RobotMap.FR_DRIVE, MotorType.kBrushless);
    bl = new CANSparkMax(RobotMap.BL_DRIVE, MotorType.kBrushless);
    br = new CANSparkMax(RobotMap.BR_DRIVE, MotorType.kBrushless);
    drive = new MecanumDrive(fl, bl, fr, br);
  }

  /**
   * @param x   How fast to move sideways. Positive for right.
   * @param y   How fast to move forward. Positive forward.
   */
    public void tank(double l, double r) {
      // temporary code (in like 10 min. at comp) for when the BL motor was totally shot.
      fl.set(l);
      br.set(-r); // temp bugfixing don't question it
      fr.set(-r); // temp bubfixing don't question it
  }

  /**
   * Stops all drive motors.
   */
  public void stop() {
      fl.set(0.0);
      fr.set(0.0);
      bl.set(0.0);
      br.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TankDrive());
  }
}
