//everything that needs to be mapped out

package frc.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class RobotMap {
  //PWM

  public static final int fl_port = 0; //slot on PWM
  public static final int fr_port = 1;
  public static final int bl_port = 2;
  public static final int br_port = 3;

  public static final int ELEVATOR = 4;
  public static final int INTAKE = 5;
  public static final int INTAKE_FLIP = 6;
  public static final int SCISSOR_LIFT = 7;

  //DIO

  public static final int fl_enc_a = 0; //slot on PWM
  public static final int fl_enc_b = 1; 
  public static final int bl_enc_a = 2;
  public static final int bl_enc_b = 3;
  public static final int br_enc_a = 4;
  public static final int br_enc_b = 5;
  public static final int fr_enc_a = 6; 
  public static final int fr_enc_b = 7;
}
