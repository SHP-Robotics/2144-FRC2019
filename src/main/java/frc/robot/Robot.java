//main file with everything 

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Autonomous;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.NavSensor;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Robot extends TimedRobot {

  public static OI oi;
  public static Drivebase drivebase;
  public static final NavSensor navsensor = new NavSensor();
  public static Limelight limelight = new Limelight(false);

  private CANSparkMax FrontLeftMotor;
  private CANSparkMax FrontRightMotor;
  private CANSparkMax BackLeftMotor;
  private CANSparkMax BackRightMotor;

  private CANEncoder fl_enc;
  private CANEncoder bl_enc;
  private CANEncoder fr_enc;
  private CANEncoder br_enc;

  Command Autonomous; 
  SendableChooser<Command> chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    drivebase = new Drivebase();

    chooser = new SendableChooser<>();
    //there will be an option on the dashboard to select this
    chooser.setDefaultOption("Default program", new Autonomous());
    //chooser.addObject("Auto", new AutonomouTest());
    SmartDashboard.putData("Auto mode", chooser);

    fl_enc = FrontLeftMotor.getEncoder();
    bl_enc = BackLeftMotor.getEncoder();
    fr_enc = FrontRightMotor.getEncoder();
    br_enc = BackRightMotor.getEncoder();

    Autonomous = new Autonomous();
  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    Autonomous = (Command) chooser.getSelected();
    Autonomous.start();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  
    if (Autonomous != null) {
      Autonomous.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    SmartDashboard.putNumber("Encoder Pos", fr_enc.getPosition());
    SmartDashboard.putNumber("Encoder Pos", br_enc.getPosition());
    SmartDashboard.putNumber("Encoder Pos", fl_enc.getPosition());
    SmartDashboard.putNumber("Encoder Pos", bl_enc.getPosition());
  }

  @Override
  public void testPeriodic() {
  }
}
