package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class AutoDrive extends CommandBase {
    private final Drivetrain drivetrain;

    private final Timer autoTimer= new Timer();

    public AutoDrive(Drivetrain drivetrain) {
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
        drivetrain.tankDrive(-0.55, -0.5, 1);
    }


    @Override
    public boolean isFinished() {
        return (autoTimer.get() >= 3);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
        autoTimer.stop();
    }
}
