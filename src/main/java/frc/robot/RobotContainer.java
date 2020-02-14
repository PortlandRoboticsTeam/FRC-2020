/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // Subsystem definitions
    private final Drivetrain drivetrain = new Drivetrain();
    //private final Elevator elevator = new Elevator();
    //private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();
    private final WheelSpinner wheelSpinner = new WheelSpinner();

    //Command definitions
    private final AutoDrive simpleAutonomousCommand = new AutoDrive(drivetrain);
    private final AutoScoreSimple complexAutonomousCommand = new AutoScoreSimple(drivetrain);

    private final Shoot shoot = new Shoot(shooter);
    private final Succ succ = new Succ(shooter);
    private final SpinWheel spinWheel = new SpinWheel(wheelSpinner);


    //Joystick definitions
    public static Joystick m_stick = new Joystick(mStickPort);
    public static Joystick s_stick = new Joystick(sStickPort);

    //Chooser definitions
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    
    //The container for the robot.  Contains subsystems, OI devices, and commands.
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        //Add options the autonomous chooser
        autoChooser.addOption("Autonomous Drive", simpleAutonomousCommand);
        autoChooser.addOption("[Incomplete] Autonomous Score", complexAutonomousCommand);

        // Put the chooser on the dashboard
        Shuffleboard.getTab("Autonomous").add(autoChooser);

        //Set driving mode
        drivetrain.setDefaultCommand(
                new DriveSlide(drivetrain,
                        () -> m_stick.getY(),
                        () -> m_stick.getX(),
                        () -> m_stick.getTwist(),
                        () -> m_stick.getThrottle(),
                        () -> m_stick.getTrigger()));

    }

    //Defines command-button mappings
    private void configureButtonBindings() {
        //Names buttons
        JoystickButton m_3 = new JoystickButton(m_stick, 3);
        JoystickButton m_4 = new JoystickButton(m_stick, 4);
        JoystickButton m_5 = new JoystickButton(m_stick, 5);

        //Binds buttons
        m_3.whenPressed(shoot);
        m_4.whenPressed(succ);
        m_5.whileHeld(spinWheel);

    }

    //Return autonomus command to this function
    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}
