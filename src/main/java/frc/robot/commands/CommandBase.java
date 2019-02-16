package frc.robot.commands;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FlipIntake;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.NavSensor;
import frc.robot.subsystems.ScissorLift;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
/**
 * An example command.  You can replace me with your own command.
 */
  public abstract class CommandBase extends Command {
  public static OI oi;
  public static final Drivebase drivebase = new Drivebase();
  
  public static final Intake intake = new Intake();
  public static final Elevator elevator = new Elevator();
  public static final FlipIntake flip_intake = new FlipIntake();
  public static final ScissorLift scissor_lift = new ScissorLift();

  public static final NavSensor navsensor = new NavSensor();

  public CommandBase() {
      requires(Robot.drivebase);
  }

  // Called just before this Command runs the first time
  public static void init() {
     oi = new OI();
     navsensor.init();
  }
}