package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveFlipIntake;
import frc.robot.commands.DriveIntake;

public class FlipIntake extends Subsystem {

    private Spark flip_intake;

    public FlipIntake() {
    
        flip_intake = new Spark(RobotMap.INTAKE_FLIP);
    }
    
    public void runMotors(double speed) {
        flip_intake.set(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveFlipIntake());
    }
}