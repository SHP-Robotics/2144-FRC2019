/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.NineteenClimb;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static final int LEFT_STICK_PORT = 1;
  public static final int RIGHT_STICK_PORT = 2;
  public static final int TRIGGER_PORT = 1;
  public static final int CLIMBER_BUTTON_PORT = 7;

  private Joystick leftStick;
  private Joystick rightStick;

  private JoystickButton climberButton;

  public OI() {
    leftStick = new Joystick(LEFT_STICK_PORT);
    rightStick = new Joystick(RIGHT_STICK_PORT);
    climberButton = new JoystickButton(rightStick, CLIMBER_BUTTON_PORT);
    // climberButton.whenPressed(new NineteenClimb());
  }

  /**
   * @return the X position of the left joystick. Right = positive.
   */
  public double get_left_x() {
    return leftStick.getX();
  }

  /**
   * @return the Y position of the left joystick. Forward = positive.
   */
  public double get_left_y() {
      return -leftStick.getY();
  }

  /**
   * @return the X position of the right joystick. Right = positive.
   */
  public double get_right_x() {
      return rightStick.getX();
  }

  /**
   * @return the Y position of the right joystick. Forward = positive.
   */
  public double get_right_y() {
      return -rightStick.getY();
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
}
