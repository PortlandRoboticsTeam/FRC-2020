package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Elevator extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this Elevator. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Elevator INSTANCE = new Elevator();

    //private final WPI_VictorSPX liftMotor = new WPI_VictorSPX(elevator1PortNum);
    private final WPI_VictorSPX hookMotor = new WPI_VictorSPX(elevator2PortNum);


    /**
     * Creates a new instance of this Elevator.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Elevator() {

    }

    public void driveElevator(double forward, double side, double throttle, boolean trigger, double scale) {
        double mod = ((-throttle+1)/2);
        //liftMotor.set(forward*mod*scale);
        if(trigger) {
            hookMotor.set(side*mod*scale);
        }
    }
    


    public void stop() {
        //liftMotor.stopMotor();
        //hookMotor.stopMotor();
    }


    /**
     * Returns the Singleton instance of this Elevator. This static method
     * should be used -- {@code Elevator.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static Elevator getInstance() {
        return INSTANCE;
    }

}

