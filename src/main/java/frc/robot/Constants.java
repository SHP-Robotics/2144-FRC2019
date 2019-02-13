package frc.robot;

public class Constants {
    public static final int K_TURN_TOLERANCE = 2; // degrees +/-
    public static final int K_TURN_SLOW_TOLERANCE = 15; // degrees +/-
    public static final double K_TURN_SLOW_SPD = 0.3; // when turning within tolerance degrees, use this spd
    public static final double K_AUTO_DRIVE_P = 0.03; // error proportional multiplier used to drive straight

    public static final int K_DRIVE_PPR = 360; // might be 360 actually
    public static final double K_DRIVE_DIA = 6; // drive wheel diameter
    public static final double K_DRIVE_CIR = Math.PI * K_DRIVE_DIA; // drive wheel circumference
    public static final double K_DRIVE_PPIN = K_DRIVE_PPR / K_DRIVE_CIR; // pulses per inch

    //intake speeds

    public static final double intake_intake_spd = -0.5;
    public static final double intake_output_spd = 1;

    //check negative and positive values

    //elevator speeds

    public static final double elevator_up_spd = -0.2;
    public static final double elevator_down_spd = 0.2;

    //flip intake speeds

    public static final double flip_up_spd = -0.2;
    public static final double flip_down_spd = 0.2;

    //scissor lift speeds

    public static final double scissor_up_spd = -0.2;
    public static final double scissor_down_spd = 0.2;

    public static final double K_DRIVE_P = 1;
    public static final double K_DRIVE_I = 1;
    public static final double K_DRIVE_D = 1;

    public static final double K_TURN_P = 0.5;
    public static final double K_TURN_I = 0.1;
    public static final double K_TURN_D = 0.1;

}