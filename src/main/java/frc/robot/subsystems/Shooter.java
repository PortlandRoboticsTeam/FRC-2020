package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this Shooter. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Shooter INSTANCE = new Shooter();

    //private final Spark shooterTop = new Spark(shooterPortNum);
    //private final Spark shooterBottom = new Spark(shooterPortNum);

    /**
     * Creates a new instance of this Shooter.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Shooter() {

    }

    public void shoot(double speed) {
        //shooterTop.set(speed);
        //shooterBottom.set(-speed);
    }

    public void succ(double speed) {
        //shooterTop.set(-speed);
        //shooterBottom.set(speed);
    }

    public void stop() {
        //shooterTop.stopMotor();
        //shooterBottom.stopMotor();
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

