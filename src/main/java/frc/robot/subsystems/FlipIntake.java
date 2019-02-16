package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveFlipIntake;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class FlipIntake extends Subsystem {

    private CANSparkMax flip_intake;

    public FlipIntake() {
    
        flip_intake = new CANSparkMax(RobotMap.INTAKE_FLIP, MotorType.kBrushless);
    }
    
    public void runMotors(double speed) {
        flip_intake.set(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveFlipIntake());
    }
}