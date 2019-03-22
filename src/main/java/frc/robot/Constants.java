package frc.robot;

public class Constants {
    // Motor Speeds
    public static final double FULL_FORWARD_POWER = 1.0;
    public static final double FULL_REVERSE_POWER = -1.0;
    public static final double LIFT_POWER = 0.1;
    public static final double NO_POWER = 0.0;

    // PID Constants
    public static final double ELEVATOR_P = 0.0005;
    public static final double ELEVATOR_I = 0.0;
    public static final double ELEVATOR_D = 0.0;
    public static final double INTAKE_P = 0.0005;
    public static final double INTAKE_I = 0.0;
    public static final double INTAKE_D = 0.0;


    // Elevator Heights
    public static final double ELEV_LOWEST = 0.0;
    public static final double ELEV_LEVEL_TWO = 0.0;
    public static final double ELEV_CLIMBER = 0.0;

    // Intake Heights
    public static final double INTAKE_UP = 0.0;
    public static final double INTAKE_DOWN = 0.0;
    public static final double INTAKE_CLIMB = 0.0;

    // More Constants
    public static final double JOYSTICK_DEAD_ZONE = 0.20;
    public static final double MAX_ELEV_ENCODER = 1.0;
    public static final double MAX_FLIP_ENCODER = 1.0;
}