package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this Shooter. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Shooter INSTANCE = new Shooter();

    private final PWMTalonSRX shooterRight = new PWMTalonSRX(shooterPortNum);
    private final PWMTalonSRX shooterLeft = new PWMTalonSRX(shooterPortNum);

    /**
     * Creates a new instance of this Shooter.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Shooter() {

    }

    public void shoot(double speed) {
        shooterRight.set(speed);
        shooterLeft.set(-speed);
    }

    /**
     * Returns the Singleton instance of this Shooter. This static method
     * should be used -- {@code Shooter.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static Shooter getInstance() {
        return INSTANCE;
    }

}

