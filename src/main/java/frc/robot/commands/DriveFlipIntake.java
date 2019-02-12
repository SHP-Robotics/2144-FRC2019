package frc.robot.commands;

public class DriveFlipIntake extends CommandBase{
    
    public DriveFlipIntake(){
        requires(flip_intake);
    }

    @Override 
    protected void initialize(){

    }

    @Override
    protected void execute(){
        elevator.runMotors(oi.get_flip_spd());
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
        flip_intake.runMotors(0);
    }

    @Override 
    protected void interrupted(){
        super.interrupted();
    }
}