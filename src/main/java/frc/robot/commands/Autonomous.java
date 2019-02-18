package frc.robot.commands;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends CommandBase{

    private CANSparkMax FrontLeftMotor;
    private CANSparkMax FrontRightMotor;
    private CANSparkMax BackLeftMotor;
    private CANSparkMax BackRightMotor;

    private CANEncoder fl_enc;
    private CANEncoder bl_enc;
    private CANEncoder fr_enc;
    private CANEncoder br_enc;

    public Autonomous(){
        requires(drivebase);
    }

    @Override
    public void initialize(){

        fl_enc = FrontLeftMotor.getEncoder();
        bl_enc = BackLeftMotor.getEncoder();
        fr_enc = FrontRightMotor.getEncoder();
        br_enc = BackRightMotor.getEncoder();

    }

    public double get_back_left_enc(){
        return bl_enc.getPosition();
    }

    public double get_back_right_enc(){
        return br_enc.getPosition();
    }

    public double get_front_left_enc(){
        return fl_enc.getPosition();
    }

    public double get_front_right_enc(){
        return fr_enc.getPosition();
    }


    @Override
    public void execute(){
        
        if(get_back_left_enc() < 1000){
            drivebase.runMotors(0.5, -0.5);
        }
    }


    @Override
    protected boolean isFinished(){
        return false;
    }
}