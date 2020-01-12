package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.RobotContainer.m_stick;


public class ArcadeDrive extends CommandBase {
    private final Drivetrain drivetrain;

    public ArcadeDrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(m_stick.getY(), m_stick.getX(), 0.8);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
