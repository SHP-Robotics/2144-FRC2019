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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.commands.ElevatorDrive;
import frc.robot.Constants;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends PIDSubsystem {

  private CANSparkMax elevator;
  private CANEncoder elevatorEncoder;

  private DigitalInput bottomLimitSwitch;
  private DigitalInput topLimitSwitch;

  /**
   * Add your docs here.
   */
  public Elevator() {
    // Intert a subsystem name and PID values here
    super("Elevator", Constants.ELEVATOR_P, Constants.ELEVATOR_I, Constants.ELEVATOR_D);
    elevator = new CANSparkMax(RobotMap.ELEVATOR, MotorType.kBrushless);
    elevatorEncoder = new CANEncoder(elevator);
    // elevatorEncoder.setPosition(0.0);

    bottomLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_BOTTOM_LIMIT);
    topLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_TOP_LIMIT);
    // this.enable();
  }

  public void setElevatorSetpoint(double setpoint) {
    this.setSetpoint(setpoint);
  }

  public void driveElev(double speed) {
    if ((bottomLimitPressed() && speed < 0.0) || (topLimitPressed() && speed > 0.0)) { 
      elevator.set(0.0);
    }
    elevator.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorDrive());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return elevatorEncoder.getPosition()/* / Constants.MAX_ELEV_ENCODER*/;
  }

  public boolean bottomLimitPressed() {
    return bottomLimitSwitch.get();
  }

  public boolean topLimitPressed() {
    return topLimitSwitch.get();
  }

  @Override
  protected void usePIDOutput(double output) {
    // if ((bottomLimitPressed() && output < 0.0) || (topLimitPressed() && output > 0.0)) { 
    //   elevator.set(0.0);
    //   this.setSetpoint(this.getPosition());
    // }
    // else
    //   elevator.set(output);
  }
}
