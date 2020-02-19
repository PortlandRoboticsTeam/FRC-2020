package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import static frc.robot.Constants.*;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.RawColor;


//Library installation link
public class WheelSpinner extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    private final static I2C.Port i2cPort = I2C.Port.kOnboard;
    private final static ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

    private final static ColorMatch m_colorMatcher = new ColorMatch();

    private final static Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final static Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final static Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final static Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    Counter motorCounter = new Counter(new DigitalInput(1));
    int position = 0;

    //private final PWMTalonSRX wheelMotor = new PWMTalonSRX(wheelSpinnerPortNum);

    private final static WheelSpinner INSTANCE = new WheelSpinner();

    /**
     * Creates a new instance of this WheelSpinner.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    public WheelSpinner() {

    }

    //Important to run before detectNamedColor(), but only needs to run once
    public static void setupColorMatch() {
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget);
    }

    /**
     * Based heavilly on REV's example program, will push detected color to dashboard.
     * This method will also return a single character string indicating which color
     * it has most likely detected
     */

    public static void detectNamedColor() {
        Color detectedColor = colorSensor.getColor();

        String colorString;
        String colorChar;
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

        if (match.color == kBlueTarget) {
            colorString = "Blue";
            colorChar = "b";
        } else if (match.color == kRedTarget) {
            colorString = "Red";
            colorChar = "r";
        } else if (match.color == kGreenTarget) {
            colorString = "Green";
            colorChar = "g";
        } else if (match.color == kYellowTarget) {
            colorString = "Yellow";
            colorChar = "y";
        } else {
            colorString = "Unknown";
            colorChar = "u";
        }

        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
        //return colorChar;
    }

    public Color getColor() {
        return colorSensor.getColor();
    }

    public RawColor getRawColor() {
        return colorSensor.getRawColor();
    }

    public static void pushRawToDashboard() {
        SmartDashboard.putNumber("Red", colorSensor.getRawColor().red);
        SmartDashboard.putNumber("Green", colorSensor.getRawColor().green);
        SmartDashboard.putNumber("Blue", colorSensor.getRawColor().blue);
        SmartDashboard.putString("Detected Color", colorSensor.getColor().toString());
        SmartDashboard.putString("Detected Color (Raw)", colorSensor.getRawColor().toString());
    }

    //To make the encoder code simpler, try to run it forward most of the time
    public void spin() {
        //wheelMotor.set(0.8);
        position += motorCounter.get();
    }

    public void spinBack() {
        //wheelMotor.set(-0.8);
        position -= motorCounter.get();
    }

    public void spinToColor(Color targetColor, int offset) {
        while (colorSensor.getColor() != targetColor) {
            //wheelMotor.set(0.1);
        }
        //wheelMotor.stopMotor();
    }
     
    public void stop() {
        //wheelMotor.stopMotor();
    }
    
    public static WheelSpinner getInstance() {
        return INSTANCE;
    }

}

