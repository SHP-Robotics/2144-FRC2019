package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.OperateMechanumDrive;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.*;

public class Drivebase extends Subsystem{

    private CANSparkMax FrontLeftMotor;
    private CANSparkMax FrontRightMotor;
    private CANSparkMax BackLeftMotor;
    private CANSparkMax BackRightMotor;
    
    private CANSparkMax scissor_lift;
    private CANSparkMax elevator;
    private CANSparkMax intake_flip;
    private CANSparkMax intake;

    private Encoder fl_enc;
    private Encoder fr_enc;
    private Encoder bl_enc;
    private Encoder br_enc;

    public MecanumDrive mecanumDrive;
    

    public Drivebase(){

        FrontLeftMotor = new CANSparkMax(RobotMap.fl_port, MotorType.kBrushless); //found in RobotMap enum
        FrontRightMotor = new CANSparkMax(RobotMap.fr_port, MotorType.kBrushless);
        BackLeftMotor = new CANSparkMax(RobotMap.bl_port, MotorType.kBrushless);
        BackRightMotor = new CANSparkMax(RobotMap.br_port, MotorType.kBrushless);

        scissor_lift = new CANSparkMax(RobotMap.SCISSOR_LIFT, MotorType.kBrushless);
        elevator = new CANSparkMax(RobotMap.ELEVATOR, MotorType.kBrushless);
        intake_flip = new CANSparkMax(RobotMap.INTAKE_FLIP, MotorType.kBrushless);
        intake = new CANSparkMax(RobotMap.INTAKE, MotorType.kBrushless);

        fl_enc = new Encoder(RobotMap.fl_enc_a, RobotMap.fl_enc_b);
        fr_enc = new Encoder(RobotMap.fr_enc_a, RobotMap.fr_enc_b);
        bl_enc = new Encoder(RobotMap.bl_enc_a, RobotMap.bl_enc_b);
        br_enc = new Encoder(RobotMap.br_enc_a, RobotMap.br_enc_b);

        mecanumDrive = new MecanumDrive(FrontLeftMotor, BackLeftMotor, FrontRightMotor, BackRightMotor);
    }

    //write mecanum cartesian from drivetrain.java

    public void mecanumCartesian(double x, double y, double rot){
        mecanumDrive.driveCartesian(x, y, rot);
    }

    public void mecanumCartesian(double x, double y, double rot, double gyro){
        mecanumDrive.driveCartesian(x, y, rot, gyro);
    }
    
    public void stop(){
        this.arcade(0, 0, false);
    }

    public void arcade(double spd, double rot){
        this.arcade(spd, rot, false);
    }

    public void arcade(double spd, double rot, boolean squared) {
        mecanumDrive.driveCartesian(0, squared ? spd * Math.abs(spd) : spd, squared ? rot * Math.abs(rot) : rot);
    }

    public void reset_encoders() {
        fl_enc.reset();
        fr_enc.reset();
        bl_enc.reset();
        br_enc.reset();
    }

    public double average_encoders() {
        return (Math.abs(fl_enc.get()) + Math.abs(fr_enc.get()) + /*Math.abs(blenc.get()) +*/ Math.abs(br_enc.get())) / 4;
    }

    public void updateEncoderData() {
        SmartDashboard.putNumber("flenc", fl_enc.get());
        SmartDashboard.putNumber("frenc", fr_enc.get());
        SmartDashboard.putNumber("blenc", bl_enc.get());
        SmartDashboard.putNumber("brenc", br_enc.get());
    }

    public boolean have_encoders_reached(int position) {
        position = Math.abs(position);
        double avg = average_encoders();
        return avg >= position;
    }

    public void initDefaultCommand(){
        setDefaultCommand(new OperateMechanumDrive());//starts the command
    }
}