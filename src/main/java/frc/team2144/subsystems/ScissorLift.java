/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2144.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2144.RobotMap;

/**
 * Add your docs here.
 */
public class ScissorLift extends Subsystem {

  private CANSparkMax scissorMotor;
  private DigitalInput topLimitSwitch, bottomLimitSwitch;
  /**
   * Add your docs here.
   */
  public ScissorLift() {
    scissorMotor = new CANSparkMax(RobotMap.SCISSOR, MotorType.kBrushed);
    bottomLimitSwitch = new DigitalInput(RobotMap.SCISSOR_BOTTOM_LIMIT);
    topLimitSwitch = new DigitalInput(RobotMap.SCISSOR_TOP_LIMIT);
  }

  public void driveScissorLift(double speed) {
    scissorMotor.set(speed);
  }

  public boolean limitSwitchPressed() {
    return bottomLimitSwitch.isAnalogTrigger() || topLimitSwitch.isAnalogTrigger();
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
