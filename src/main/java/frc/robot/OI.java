/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.lang.Math;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.NineteenClimb;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static final int LEFT_STICK_PORT = 1;
  public static final int RIGHT_STICK_PORT = 0;
  public static final int TRIGGER_PORT = 1;
  public static final int LOW_BUTTON_PORT = 3; // switched
  public static final int HIGH_BUTTON_PORT = 2; // temp switched
  public static final int CLIMBER_BUTTON_PORT = 7;

  private Joystick leftStick;
  private Joystick rightStick;

  private JoystickButton climberButton;

  public OI() {
    leftStick = new Joystick(LEFT_STICK_PORT);
    rightStick = new Joystick(RIGHT_STICK_PORT);
    climberButton = new JoystickButton(rightStick, CLIMBER_BUTTON_PORT);
    climberButton.whenPressed(new NineteenClimb());
  }

  /**
   * @return the X position of the left joystick. Right = positive.
   */
  public double get_left_x() {
    if (Math.abs(leftStick.getX()) < Constants.JOYSTICK_DEAD_ZONE)
      return 0;
    return Math.abs(leftStick.getX())*leftStick.getX();
  }

  /**
   * @return the Y position of the left joystick. Forward = positive.
   */
  public double get_left_y() {
    if (Math.abs(leftStick.getY()) < Constants.JOYSTICK_DEAD_ZONE)
      return 0;
    return -1*Math.abs(leftStick.getY())*leftStick.getY();
  }

  /**
   * @return the X position of the right joystick. Right = positive.
   */
  public double get_right_x() {
    if (Math.abs(rightStick.getX()) < Constants.JOYSTICK_DEAD_ZONE)
      return 0;
    return Math.abs(rightStick.getX())*rightStick.getX();
  }

  /**
   * @return the Y position of the right joystick. Forward = positive.
   */
  public double get_right_y() {
    if (Math.abs(rightStick.getY()) < Constants.JOYSTICK_DEAD_ZONE)
      return 0;
    return -1*Math.abs(rightStick.getY())*rightStick.getY();
  }

  /**
   * @return whether the trigger on the left joystick is pressed or not.
   */
  public boolean leftTriggerPressed() {
    return leftStick.getRawButton(TRIGGER_PORT);
  }

  /**
   * @return whether the trigger on the right joystick is pressed or not.
   */
  public boolean rightTriggerPressed() {
    return rightStick.getRawButton(TRIGGER_PORT);
  }

  public boolean leftLowPressed() {
    return leftStick.getRawButton(LOW_BUTTON_PORT);
  }

  public boolean rightLowPressed() {
    return rightStick.getRawButton(LOW_BUTTON_PORT);
  }

  public boolean leftHighPressed() {
    return leftStick.getRawButton(HIGH_BUTTON_PORT);
  }

  public boolean rightHighPressed() {
    return rightStick.getRawButton(HIGH_BUTTON_PORT);
  }

  public boolean fullSendPressed() {
    return rightStick.getRawButton(5);
  }
}
