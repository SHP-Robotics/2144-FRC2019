package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveElevator;

public class Elevator extends Subsystem {

    private Spark elevator;

    public Elevator() {
    
        elevator = new Spark(RobotMap.ELEVATOR);
    }
    
    public void runMotors(double speed) {
        elevator.set(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveElevator());
    }
}
