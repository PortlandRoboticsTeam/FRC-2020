package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;


public class Shoot extends CommandBase {
    private final Shooter shooter;
    private final Double speed;

    public Shoot(Shooter shooter, Double speedInput) {
        this.shooter = shooter;
        speed = speedInput;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        shooter.shoot(speed);
        
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
