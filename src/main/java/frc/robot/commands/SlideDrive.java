package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.RobotContainer.*;


public class SlideDrive extends CommandBase {
    private final Drivetrain drivetrain;

    public SlideDrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrain.slideDrive(m_stick.getY(), m_stick.getX(), m_stick.getTwist(), m_stick.getRawButton(1),0.8);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
