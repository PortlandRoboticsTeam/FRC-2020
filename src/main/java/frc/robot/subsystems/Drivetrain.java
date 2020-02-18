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


    private final static Drivetrain INSTANCE = new Drivetrain();

    public Drivetrain() {

    }

    public void stop() {
        leftFront.stopMotor();
        leftRear.stopMotor();
        rightFront.stopMotor();
        rightRear.stopMotor();
        centerOne.stopMotor();
        centerTwo.stopMotor();
    }

    public double smoothLogisticInput(double input) {
        if (input > 0.1) {
            return 1/(1 + Math.exp(-10*Math.abs(input)+5));
        } else if (input < -0.1) {
            return -(1/(1 + Math.exp(-10*Math.abs(input)+5)));
        } 
        return 0;
    }

    public void slideDrive(double forward, double side, double twist, double throttle, boolean button, double scale) {
        forward = smoothLogisticInput(forward) * scale;
        side = smoothLogisticInput(side) * scale;
        twist = smoothLogisticInput(twist) * scale;

        if (button) {
            double mod = ((-throttle+1)/2);
            forward *= mod;
            side *= mod;
            twist *= mod;
        }

        drive.arcadeDrive(forward, twist);
        center.set(side);
        drive.feedWatchdog();
    }

    public void slideDriveSimple(double forward, double side, double twist, double scale) {
        drive.arcadeDrive(forward*scale, twist*scale);
        center.set(side*scale);
        drive.feedWatchdog();
    }

    public void tankDrive(double right, double left, double scale) {
        drive.tankDrive(left*scale, right*scale);
        drive.feedWatchdog();
    }

    public void arcadeDrive(double forward, double rotation, double scale) {
        drive.arcadeDrive(forward*scale, rotation*scale);
    }

    public void curvatureDrive(double forward, double turn, double scale) {
        drive.curvatureDrive(forward*scale, turn*scale, true);
    }


    public static Drivetrain getInstance() {
        return INSTANCE;
    }

}

