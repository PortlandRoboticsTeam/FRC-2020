package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this Shooter. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static Shooter INSTANCE = new Shooter();

    /**
     * Creates a new instance of this Shooter.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public Shooter() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
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

