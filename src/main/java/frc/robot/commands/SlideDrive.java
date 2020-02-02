package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;


public class SlideDrive extends CommandBase {
    private final Drivetrain drive;
    private final DoubleSupplier forward;
    private final DoubleSupplier side;
    private final DoubleSupplier twist;


    public SlideDrive(Drivetrain drivetrain, DoubleSupplier forwardInput, DoubleSupplier sideInput, DoubleSupplier twistInput) {
        drive = drivetrain;
        forward = forwardInput;
        side = sideInput;
        twist = twistInput;
        addRequirements(drive);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        //drivetrain.slideDrive(m_stick.getY(), m_stick.getX(), m_stick.getTwist(), /*m_stick.getThrottle(), m_stick.getTrigger(),*/ 0.8);
        //drivetrain.slideDriveSimple(m_stick.getY(), m_stick.getX(), m_stick.getTwist());
        drive.slideDriveSimple(forward.getAsDouble(), side.getAsDouble(), twist.getAsDouble(), 0.8);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }
}
