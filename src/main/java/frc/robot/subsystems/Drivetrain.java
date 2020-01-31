package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    private final static WPI_VictorSPX rightFront = new WPI_VictorSPX(wheel1PortNum);
    private final static WPI_VictorSPX rightRear = new WPI_VictorSPX(wheel2PortNum);
    private final static WPI_VictorSPX leftFront = new WPI_VictorSPX(wheel3PortNum);
    private final static WPI_VictorSPX leftRear = new WPI_VictorSPX(wheel4PortNum);
    private final static WPI_VictorSPX centerOne = new WPI_VictorSPX(wheel5PortNum);
    private final static WPI_VictorSPX centerTwo = new WPI_VictorSPX(wheel6PortNum);

    private final static SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightRear);
    private final static SpeedControllerGroup left = new SpeedControllerGroup(leftFront, leftRear);
    private final static SpeedControllerGroup center = new SpeedControllerGroup(centerOne, centerTwo);

    private final static DifferentialDrive drive = new DifferentialDrive(right, left);

    /**
     * The Singleton instance of this Drivetrain. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Drivetrain INSTANCE = new Drivetrain();

    /**
     * Creates a new instance of this Drivetrain.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Drivetrain() {

    }

    private double deadZone(double input) {
        if (Math.abs(input) > 0.2) {
            return input;
        } else {
            return 0;
        }
    }

    public void stop() {
        leftFront.stopMotor();
        leftRear.stopMotor();
        rightFront.stopMotor();
        rightRear.stopMotor();
        centerOne.stopMotor();
        centerTwo.stopMotor();
    }

    public void slideDrive(double forward, double side, double twist, double throttle, boolean button, double scale) {

        if (button) {
            double mod = ((-throttle+1)/2);
            forward *= mod;
            side *= mod;
            twist *= mod;
        }

        drive.arcadeDrive(forward*scale, twist*scale);
        center.set(deadZone(side)*scale);
        drive.feedWatchdog();
    }

    public void slideDriveSimple(double forward, double side, double twist) {
        drive.arcadeDrive(forward, twist);
        center.set(side);
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

