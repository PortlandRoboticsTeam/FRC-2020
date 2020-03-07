package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;


public class AutoScoreSimple extends CommandBase {
    private final Drivetrain drivetrain;
    private final Shooter shooter = new Shooter();

    private final Timer autoTimer = new Timer();

    public AutoScoreSimple(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        autoTimer.reset();
        autoTimer.start();
    }

    @Override
    public void execute() {
        while (autoTimer.get() <= 5) {
            shooter.shoot(1.0);
        }
        while (autoTimer.get() >= 10) {
            drivetrain.tankDrive(-0.5, -0.5, 1);
        }
    }

    @Override
    public boolean isFinished() {
        return (autoTimer.get() >= 15);
    }

    @Override
    public void end(boolean interrupted) {
        autoTimer.stop();
        drivetrain.stop();
    }
}
