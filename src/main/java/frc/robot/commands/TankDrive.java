package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.RobotContainer.m_stick;
import static frc.robot.RobotContainer.s_stick;


public class TankDrive extends CommandBase {
    private final Drivetrain drivetrain;

    public TankDrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrain.tankDrive(m_stick.getY(), s_stick.getY(), 0.8);
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
