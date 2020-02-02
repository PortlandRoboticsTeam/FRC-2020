package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.util.Color;
//import com.revrobotics.*;

import static frc.robot.Constants.*;

import com.revrobotics.ColorSensorV3;


//Library installation link
public class WheelSpinner extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    private final I2C.Port i2cPort = I2C.Port.kOnboard;

    private final PWMTalonSRX wheelMotor = new PWMTalonSRX(wheelSpinnerPortNum);
    //private final Encoder colorWheelEncoder = new Encoder(1,2);
    private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

    private final static WheelSpinner INSTANCE = new WheelSpinner();

    /**
     * Creates a new instance of this WheelSpinner.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public WheelSpinner() {

    }

    public void configureColorSensor() {
        //colorSensor.configureColorSensor();
        //colorSensor.configureProximitySensor();
    }
    
    public void spinToColor(Color targetColor, int offset) {
        while (colorSensor.getColor() != targetColor) {
            wheelMotor.set(0.1);
        }
        wheelMotor.stopMotor();
    }

    public Color getColor() {
        return colorSensor.getColor();
    }

    public ColorSensorV3.RawColor getRawColor() {
        return colorSensor.getRawColor();
    }
    
    public void spinRight() {
        //Spin clockwise?
        wheelMotor.set(0.5);
    }

    public void spinLeft() {
        //Spin counterclockwise?
        wheelMotor.set(-0.5);
    }
    
    public void pushToDashboard() {
        SmartDashboard.putNumber("Red", colorSensor.getColor().red);
        SmartDashboard.putNumber("Green", colorSensor.getColor().green);
        SmartDashboard.putNumber("Blue", colorSensor.getColor().blue);
        SmartDashboard.putString("Detected Color", colorSensor.getColor().toString());
    }

    public void stop() {
        wheelMotor.stopMotor();
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

