package frc.robot.commands;

public class DriveElevator extends CommandBase{
    
    public DriveElevator(){
        requires(elevator);
    }

    @Override 
    protected void initialize(){

    }

    @Override
    protected void execute(){
        elevator.runMotors(oi.get_elevator_spd());
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
        elevator.runMotors(0);
    }

    @Override 
    protected void interrupted(){
        super.interrupted();
    }
}