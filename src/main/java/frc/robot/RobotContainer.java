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
    private final Drivetrain drivetrain = new Drivetrain();
    //private final Elevator elevator = new Elevator();
    //private final Intake intake = new Intake();
    //private final Shooter shooter = new Shooter();
    private final WheelSpinner wheelSpinner = new WheelSpinner();

    // Command definitions
    private final SimpleDriveAuto simpleAutonomousCommand = new SimpleDriveAuto(drivetrain);
    private final ScoreAuto complexAutonomousCommand = new ScoreAuto(drivetrain);
    private final SlideDrive slideDrive = new SlideDrive(drivetrain);
    private final ArcadeDrive arcadeDrive = new ArcadeDrive(drivetrain);
    private final TankDrive tankDrive = new TankDrive(drivetrain);
    private final CurvatureDrive curvatureDrive = new CurvatureDrive(drivetrain);

    //private final BarBalance barBalance = new BarBalance(elevator);
    //private final IntakeSucc intakeSucc = new IntakeSucc(intake);
    //private final Shoot shoot = new Shoot(shooter);
    //private final SpinWheel spinWheel = new SpinWheel(wheelSpinner);


    //Joystick definitions
    public static Joystick m_stick = new Joystick(0);
    public static Joystick s_stick = new Joystick(1);

    //Chooser definitions
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();

        //Add options the autonomous chooser
        autoChooser.addOption("Autonomous Drive", simpleAutonomousCommand);
        autoChooser.addOption("[Incomplete] Autonomous Score", complexAutonomousCommand);

        // Put the chooser on the dashboard
        Shuffleboard.getTab("Autonomous").add(autoChooser);

        //Set driving mode
        drivetrain.setDefaultCommand(slideDrive);
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */
    private void configureButtonBindings()
    {
        //Names buttons
        JoystickButton secondTrigger = new JoystickButton(s_stick, 1);
        JoystickButton m_2 = new JoystickButton(m_stick, 2);
        JoystickButton m_3 = new JoystickButton(m_stick, 3);
        JoystickButton m_4 = new JoystickButton(m_stick, 4);
        JoystickButton s_3 = new JoystickButton(s_stick, 3);
        JoystickButton s_4 = new JoystickButton(s_stick, 4);


        //Binds buttons
        //secondTrigger.whenPressed(shoot);
        //m_2.whileHeld(intakeSucc);
        //s_3.whileHeld(elevator down);
        //s_4.whileHeld(elevator up);
        //s_5.whileHeld(spin color wheelone way);
        //s_6.whileHeld(spin other way);


    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        //return autonomousCommand;
        return autoChooser.getSelected();
    }
}
