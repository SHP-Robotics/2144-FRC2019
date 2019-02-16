package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveIntake;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Intake extends Subsystem {

    private CANSparkMax intake;

    public Intake() {
    
        intake = new CANSparkMax(RobotMap.INTAKE, MotorType.kBrushless);
    }
    
    public void runMotors(double speed) {
        intake.set(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveIntake());
    }
}
