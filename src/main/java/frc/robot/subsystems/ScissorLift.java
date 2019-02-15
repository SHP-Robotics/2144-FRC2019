package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveScissorLift;

public class ScissorLift extends Subsystem {

    private Spark scissor_lift;

    public ScissorLift() {
    
        scissor_lift = new Spark(RobotMap.SCISSOR_LIFT);
    }
    
    public void runMotors(double speed) {
        scissor_lift.set(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveScissorLift());
    }
}
