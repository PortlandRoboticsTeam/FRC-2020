package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this Drivetrain. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Drivetrain INSTANCE = new Drivetrain();


    private final Spark frontRight = new Spark(0);
    private final Spark rearRight = new Spark(1);
    private final Spark frontLeft = new Spark(2);
    private final Spark rearLeft = new Spark(3);

    private final PWMSparkMax center = new PWMSparkMax(5);

    private final SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, rearRight);
    private final SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, rearLeft);

    private final DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);

    /**
     * Creates a new instance of this Drivetrain.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Drivetrain() {

    }

    private double deadZone(double input) {
        if (input >= 0.2 || input <= -0.2) {
            return input;
        } else {
            return 0;
        }
    }

    public void stop() {
        frontLeft.stopMotor();
        frontRight.stopMotor();
        rearLeft.stopMotor();
        rearRight.stopMotor();
        center.stopMotor();
    }

    public void slideDrive(double forward, double side, double twist, double scale) {
        drive.arcadeDrive(forward*scale, twist*scale);
        center.set(deadZone(side*scale));
        drive.feedWatchdog();
    }

    public void tankDrive(double right, double left, double scale) {
        drive.tankDrive(left*scale, right*scale);
    }

    public void arcadeDrive(double forward, double rotation, double scale) {
        drive.arcadeDrive(forward*scale, rotation*scale);
    }

    public void curvatureDrive(double forward, double turn, double scale) {
        drive.curvatureDrive(forward*scale, turn*scale, true);
    }


    /**
     * Returns the Singleton instance of this Drivetrain. This static method
     * should be used -- {@code Drivetrain.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static Drivetrain getInstance() {
        return INSTANCE;
    }

}

