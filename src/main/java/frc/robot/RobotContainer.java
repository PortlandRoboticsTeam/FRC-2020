/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
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
    private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    private final Drivetrain drivetrain = new Drivetrain();
    private final Elevator elevator = new Elevator();
    private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();
    private final WheelSpinner wheelSpinner = new WheelSpinner();

    // Command definitions
    private final ExampleCommand autonomousCommand = new ExampleCommand(exampleSubsystem);
    private final SlideDrive slideDrive = new SlideDrive(drivetrain);
    private final ArcadeDrive arcadeDrive = new ArcadeDrive(drivetrain);
    private final TankDrive tankDrive = new TankDrive(drivetrain);
    private final CurvatureDrive curvatureDrive = new CurvatureDrive(drivetrain);

    //Joystick definitions
    public static Joystick m_stick = new Joystick(0);
    public static Joystick s_stick = new Joystick(1);

    //Chooser definitions
    SendableChooser<Command> autoChooser = new SendableChooser<>();
    SendableChooser<Command> driveChooser = new SendableChooser<>();

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();

        //Add options to the choosers
        autoChooser.addOption("Autonomous 1", autonomousCommand);
        autoChooser.addOption("Autonomous 2", autonomousCommand);

        driveChooser.addOption("Slide Drive", slideDrive);
        driveChooser.addOption("Tank Drive", tankDrive);
        driveChooser.addOption("Curvature Drive", curvatureDrive);
        driveChooser.addOption("Arcade Drive", arcadeDrive);

        // Put the choosers on the dashboard
        Shuffleboard.getTab("Autonomous").add(autoChooser);
        Shuffleboard.getTab("Drive Mode").add(driveChooser);

        drivetrain.setDefaultCommand(driveChooser.getSelected());
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */
    private void configureButtonBindings()
    {
        JoystickButton mainTrigger = new JoystickButton(m_stick, 1);
        mainTrigger.whenPressed(autonomousCommand);

    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        //return autonomousCommand;
        return autoChooser.getSelected();
    }
}
