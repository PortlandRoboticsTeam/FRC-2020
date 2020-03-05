package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Elevator extends SubsystemBase {

    private final static Elevator INSTANCE = new Elevator();

    private final WPI_VictorSPX liftMotor = new WPI_VictorSPX(elevatorLiftPortNum);
    private final WPI_VictorSPX hookMotor = new WPI_VictorSPX(elevatorHookPortNum);

    public Elevator() {

    }

    public void driveElevator(double forward, double side, double throttle, boolean trigger, double scale) {
        double mod = ((-throttle+1)/2);
        liftMotor.set(forward*mod*scale);
        if(trigger) {
            hookMotor.set(side*mod*scale);
        }
    }

    public void elevatorUp() {
        liftMotor.set(0.5);
    }

    public void elevatorDown() {
        liftMotor.set(-0.5);
    }
    
    public void hookForward() {
        hookMotor.set(0.5);
    }

    public void hookBack() {
        hookMotor.set(-0.5);
    }


    public void stop() {
        liftMotor.stopMotor();
        hookMotor.stopMotor();
    }


    public static Elevator getInstance() {
        return INSTANCE;
    }

}

