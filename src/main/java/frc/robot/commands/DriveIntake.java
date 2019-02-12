package frc.robot.commands;

public class DriveIntake extends CommandBase{
    
    public DriveIntake(){
        requires(intake);
    }

    @Override 
    protected void initialize(){

    }

    @Override
    protected void execute(){
        intake.runMotors(oi.get_intake_spd());
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
        intake.runMotors(0);
    }

    @Override 
    protected void interrupted(){
        super.interrupted();
    }
}