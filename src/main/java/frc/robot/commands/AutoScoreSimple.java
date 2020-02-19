package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
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

    /**
     * The initial subroutine of a command.  Called once when the command is initially scheduled.
     */
    @Override
    public void initialize() {
        autoTimer.reset();
        autoTimer.start();
    }

    /**
     * The main body of a command.  Called repeatedly while the command is scheduled.
     * (That is, it is called repeatedly until {@link #isFinished()}) returns true.)
     */
    @Override
    public void execute() {
        new SequentialCommandGroup(new ShootOne(shooter, 0.8), new ShootOne(shooter, 0.8), new ShootOne(shooter, 0.8));
        //new Shoot(shooter, 0.8)
        while (autoTimer.get() >= 10) {
            drivetrain.tankDrive(-0.55, -0.5, 1);
        }
    }

    @Override
    public boolean isFinished() {
        return (autoTimer.get() >= 15);
    }

    /**
     * The action to take when the command ends. Called when either the command
     * finishes normally -- that is it is called when {@link #isFinished()} returns
     * true -- or when  it is interrupted/canceled. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the command.
     *
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted) {
        autoTimer.stop();
        drivetrain.stop();
    }
}
