package frc.robot.commands;
import frc.robot.subsystems.Drivebase;

import frc.robot.subsystems.NavSensor;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
/**
 * An example command.  You can replace me with your own command.
 */
  public abstract class CommandBase extends Command {
  public static OI oi;
  public static final Drivebase drivebase = new Drivebase();

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