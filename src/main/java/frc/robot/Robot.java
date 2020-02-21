/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.WheelSpinner;


/**
 * The VM is configured to automatically run this class, and to call the
 * methods corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
    private Command autonomousCommand;

    private RobotContainer robotContainer;

    BuiltInAccelerometer acceleromenter = new BuiltInAccelerometer();
    AddressableLED m_led;
    AddressableLEDBuffer m_ledBuffer;
    int m_rainbowFirstPixelHue = 0;
    int start = 0;
    double x = 0;

    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit()
    {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.
        robotContainer = new RobotContainer();
        m_led = new AddressableLED(0);

        m_ledBuffer = new AddressableLEDBuffer(150);
        m_led.setLength(m_ledBuffer.getLength());

        m_led.setData(m_ledBuffer);
        m_led.start();
    }

    /**
     * This method is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic()
    {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /**
     * This method is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit()
    {
    }

    @Override
    public void disabledPeriodic()
    {
        teamColors();
        m_led.setData(m_ledBuffer);
    }

    /**
     * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
     */
    @Override
    public void autonomousInit()
    {
        autonomousCommand = robotContainer.getAutonomousCommand();

        // schedule the autonomous command (example)
        if (autonomousCommand != null)
        {
            autonomousCommand.schedule();
        }
    }

    /**
     * This method is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {
    }

    @Override
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
        {
            autonomousCommand.cancel();
        }
        WheelSpinner.setupColorMatch();
    }

    /**
     * This method is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic()
    {
        WheelSpinner.pushRawToDashboard();
        int[] color = WheelSpinner.detectNamedColor();
        SmartDashboard.putData("Accelerometer", acceleromenter);
        
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, color[0], color[1], color[2]);
         }
         
         m_led.setData(m_ledBuffer);
    }

    @Override
    public void testInit()
    {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This method is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {
        rainbow();
        m_led.setData(m_ledBuffer);
    }

    private void rainbow() {
        
        // For every pixel
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
          // Calculate the hue - hue is easier for rainbows because the color
          // shape is a circle so only one value needs to precess
          final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;
          // Set the value
          m_ledBuffer.setHSV(i, hue, 255, 128);
        }
        // Increase by to make the rainbow "move"
        m_rainbowFirstPixelHue += 3;
        // Check bounds
        m_rainbowFirstPixelHue %= 180;
      }

      
    private void teamColors() {
        x++;
        for (var i = 0; i < m_ledBuffer.getLength(); i+=4) {
            m_ledBuffer.setHSV(i, 0, (int)(128*Math.cos(((Math.PI / 128) * x)-1) + 128), 
                                     (int)(128*Math.cos(((Math.PI / 64) * x)-1) + 128));
          }
        for (var i = 1; i < m_ledBuffer.getLength(); i+=4) {
            m_ledBuffer.setHSV(i, 0, (int)(128*Math.cos(((Math.PI / 128) * (x+64))-1) + 128), 
                                     (int)(128*Math.cos(((Math.PI / 64) * (x+32))-1) + 128));
        }
        for (var i = 2; i < m_ledBuffer.getLength(); i+=4) {
            m_ledBuffer.setHSV(i, 0, (int)(128*Math.cos(((Math.PI / 128) * (x+128))-1) + 128), 
                                     (int)(128*Math.cos(((Math.PI / 64) * (x+64))-1) + 128));
        }
        for (var i = 3; i < m_ledBuffer.getLength(); i+=4) {
            m_ledBuffer.setHSV(i, 0, (int)(128*Math.cos(((Math.PI / 128) * (x+192))-1) + 128), 
                                     (int)(128*Math.cos(((Math.PI / 64) * (x+96))-1) + 128));
        }
          
         
          
    }
}
