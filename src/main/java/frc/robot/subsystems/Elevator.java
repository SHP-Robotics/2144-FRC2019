package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveElevator;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Elevator extends Subsystem {

    private CANSparkMax elevator;

    public Elevator() {
    
        elevator = new CANSparkMax(RobotMap.ELEVATOR, MotorType.kBrushless);
    }
    
    public void runMotors(double speed) {
        elevator.set(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveElevator());
    }
}
