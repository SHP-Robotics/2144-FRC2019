package frc.robot.commands;

public class DriveScissorLift extends CommandBase{
    
    public DriveScissorLift(){
        requires(scissor_lift);
    }

    @Override 
    protected void initialize(){

    }

    @Override
    protected void execute(){
        scissor_lift.runMotors(oi.get_scissor_spd());
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
        scissor_lift.runMotors(0);
    }

    @Override 
    protected void interrupted(){
        super.interrupted();
    }
}