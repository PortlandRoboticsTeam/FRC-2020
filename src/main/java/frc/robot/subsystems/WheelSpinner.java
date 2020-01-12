package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSpinner extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this WheelSpinner. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static WheelSpinner INSTANCE = new WheelSpinner();


    private final PWMTalonSRX wheelMotor = new PWMTalonSRX(0);
    private final Encoder colorWheelEncoder = new Encoder(1,2);

    /**
     * Creates a new instance of this WheelSpinner.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public WheelSpinner() {

    }

    public void spinRight() {
        //Spin clockwise
        wheelMotor.set(0.5);
    }

    public void spinLeft() {
        //Spin counterclockwise
        wheelMotor.set(-0.5);
    }


    /**
     * Returns the Singleton instance of this WheelSpinner. This static method
     * should be used -- {@code WheelSpinner.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static WheelSpinner getInstance() {
        return INSTANCE;
    }

}

