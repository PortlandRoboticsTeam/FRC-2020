package frc.robot.subsystems;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this Elevator. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Elevator INSTANCE = new Elevator();


    private final PWMTalonSRX liftMotor = new PWMTalonSRX(0);
    private final PWMTalonSRX hookMotor = new PWMTalonSRX(1);

    private final Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);
    private final Accelerometer accelerometer = new BuiltInAccelerometer();

    /**
     * Creates a new instance of this Elevator.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Elevator() {

    }

    public void elevatorUp() {
        liftMotor.set(0.8);
    }

    public void elevatorDown() {
        liftMotor.set(-0.8);
    }

    public void hookForward() {
        hookMotor.set(0.8);
    }

    public void hookBack() {
        hookMotor.set(-0.8);
    }

    public void stop() {
        liftMotor.set(0.00001);
        hookMotor.set(0.00001);
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
