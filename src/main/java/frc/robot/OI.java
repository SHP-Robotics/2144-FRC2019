//objects for joysticks/buttons
//methods for using joysticks

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

  public static final double JOY_DEADZONE = 0.05;

  public final Joystick LEFT_JOY = new Joystick(0);
  public final Joystick RIGHT_JOY = new Joystick(1);

  public double getLeftJoyX(){
    double raw = LEFT_JOY.getX();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw; //if raw is less than deadzone, return zero
    
  }

  public double getLeftJoyY(){
    double raw = LEFT_JOY.getY();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw; //if raw is less than deadzone, return zero
    
  }

  public double getRightJoyX(){
    double raw = RIGHT_JOY.getX();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw; //if raw is less than deadzone, return zero
    
  }

  public double getRightJoyY(){
    double raw = RIGHT_JOY.getY();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw; //if raw is less than deadzone, return zero
    
  }

  public double getRightJoyZ(){
    double raw = RIGHT_JOY.getZ();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw; //if raw is less than deadzone, return zero
    
  }

  //who knows?

  public boolean get_intake_pos() {
    return !RIGHT_JOY.getRawButton(ControlMap.intake_position);
  }
  
  public double get_guide_power() {
    return RIGHT_JOY.getRawButton(6) || RIGHT_JOY.getRawButton(3) ? 0.5 : RIGHT_JOY.getRawButton(5) ? -1 : 0;
  }

  public double get_climb_power() {
    return RIGHT_JOY.getRawButton(4) ? 1 : RIGHT_JOY.getRawButton(6) || RIGHT_JOY.getRawButton(7) ? -1 : 0;
  }

  //intake 

  public boolean get_intake() {
    return RIGHT_JOY.getRawButton(ControlMap.intake_intake);
  }

  public boolean get_output() {
    return LEFT_JOY.getRawButton(ControlMap.intake_output);
  }

  public double get_intake_spd() {
    return get_intake() ? Constants.intake_intake_spd : get_output() ? Constants.intake_output_spd : 0;
  }

  //elevator

  public boolean get_elevator_up() {
    return RIGHT_JOY.getRawButton(ControlMap.elevator_up);
  }

  public boolean get_elevator_down() {
    return LEFT_JOY.getRawButton(ControlMap.elevator_down);
  }

  public double get_elevator_spd() {
    return get_elevator_up() ? Constants.elevator_up_spd : get_output() ? Constants.elevator_down_spd : 0;
  }

  //flip intake

  public boolean get_flip_up() {
    return RIGHT_JOY.getRawButton(ControlMap.flip_up);
  }

  public boolean get_flip_down() {
    return LEFT_JOY.getRawButton(ControlMap.flip_down);
  }

  public double get_flip_spd() {
    return get_flip_up() ? Constants.flip_up_spd : get_output() ? Constants.flip_down_spd : 0;
  }

  //scissor lift

  public boolean get_scissor_up() {
    return RIGHT_JOY.getRawButton(ControlMap.scissor_up);
  }

  public boolean get_scissor_down() {
    return LEFT_JOY.getRawButton(ControlMap.scissor_down);
  }

  public double get_scissor_spd() {
    return get_flip_up() ? Constants.scissor_up_spd : get_output() ? Constants.scissor_down_spd : 0;
  }

  //

  public OI(){

  }
}
