package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveIntake;

public class Intake extends Subsystem {

    private Spark intake;

    public Intake() {
    
        intake = new Spark(RobotMap.INTAKE);
    }
    
    public void runMotors(double speed) {
        intake.set(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveIntake());
    }
}
