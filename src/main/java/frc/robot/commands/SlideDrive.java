package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;


public class SlideDrive extends CommandBase {
    private final Drivetrain drive;
    private final DoubleSupplier forward;
    private final DoubleSupplier side;
    private final DoubleSupplier twist;
    private final DoubleSupplier throttle;
    private final BooleanSupplier trigger;


    public SlideDrive(Drivetrain drivetrain, DoubleSupplier forwardInput, DoubleSupplier sideInput, DoubleSupplier twistInput, DoubleSupplier throttleInput, BooleanSupplier triggerInput) {
        drive = drivetrain;
        forward = forwardInput;
        side = sideInput;
        twist = twistInput;
        throttle = throttleInput;
        trigger = triggerInput;
        addRequirements(drive);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drive.slideDrive(forward.getAsDouble(), side.getAsDouble(), twist.getAsDouble(), throttle.getAsDouble(), trigger.getAsBoolean(), 1);
        //drivetrain.slideDriveSimple(m_stick.getY(), m_stick.getX(), m_stick.getTwist());
        //drive.slideDriveSimple(forward.getAsDouble(), side.getAsDouble(), twist.getAsDouble(), 0.5);
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
