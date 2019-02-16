/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2144;

import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.buttons.*;
import frc.team2144.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick leftStick = new Joystick(1); // i have no idea whether this number is right
  Joystick rightStick = new Joystick(2); // i have no idea whether this number is right


  // I want to have the buttons on the base of the joystick for totally automated processes.
      // e.g. I want the scissor lift to be automated.
  // not sure about the button numbers for this part. based off of the button labels on the joystick
    // these buttons are on the top of the Joystick, labeled accordingly.
  JoystickButton intakeTrigger = new JoystickButton(leftStick, 1);
  JoystickButton outtakeTrigger = new JoystickButton(rightStick, 1);

  public OI() {
    bindButtons();
  }

  private void bindButtons() {
    intakeTrigger.whileHeld(new IntakeDrive(true));
    outtakeTrigger.whileHeld(new IntakeDrive(false));
  }

  // JoystickButton stageOne = new JoystickButton(rightStick, 4);
  // JoystickButton stageTwo = new JoystickButton(rightStick, 3);
  // JoystickButton stageThree = new JoystickButton(rightStick, 5);
  
  // JoystickButton diskMode = new JoystickButton(leftStick, 4); // changes the constants for the elevator stages
  // JoystickButton ballMode = new JoystickButton(leftStick, 5); // changes the constants for the elevator stages

  // JoystickButton intakeDown = new JoystickButton(leftStick, 3);
  // JoystickButton intakeUp = new JoystickButton(leftStick, 2);

  // JoystickButton eStop = new JoystickButton(rightStick, 6);
  // JoystickButton scissorBoi = new JoystickButton(rightStick, 11);
  
  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
