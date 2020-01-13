package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Intake extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this Intake. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Intake INSTANCE = new Intake();

    private final PWMTalonSRX intakeRight = new PWMTalonSRX(intakePortNum);
    private final PWMTalonSRX intakeLeft = new PWMTalonSRX(intakePortNum);

    /**
     * Creates a new instance of this Intake.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Intake() {

    }

    public void succ(double speed) {
        intakeRight.set(-speed);
        intakeLeft.set(speed);
    }

    /**
     * Returns the Singleton instance of this Intake. This static method
     * should be used -- {@code Intake.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static Intake getInstance() {
        return INSTANCE;
    }

}

