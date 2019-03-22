/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // CAN Wires, SPARK MAX Configured
  public static final int FL_DRIVE = 1;
  public static final int FR_DRIVE = 2;
  public static final int BL_DRIVE = 3;
  public static final int BR_DRIVE = 4;
  
  public static final int SCISSOR = 5;
  public static final int ELEVATOR = 6;
  public static final int INTAKE_FLIP = 7;
  public static final int INTAKE_DRIVE = 8;

  // PWM Wires
  public static final int SCISSOR_BOTTOM_LIMIT = 0;
  public static final int SCISSOR_TOP_LIMIT = 1;
  public static final int ELEVATOR_BOTTOM_LIMIT = 9;
  public static final int ELEVATOR_TOP_LIMIT = 7;
}
