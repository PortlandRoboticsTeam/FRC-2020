/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    //Example constant definition
    public static final int teamNumber = 7195;

    //CAN port numberings
    public static final int wheel1PortNum = 0;  //front right
    public static final int wheel2PortNum = 1;  //rear right
    public static final int wheel3PortNum = 2;  //front left
    public static final int wheel4PortNum = 3;  //rear left
    public static final int wheel5PortNum = 4;  //center

    //PWM port numberings
    public static final int elevator1PortNum = 0;
    public static final int elevator2PortNum = 0;
    public static final int intakePortNum = 0;
    public static final int shooterPortNum = 0;
    public static final int wheelSpinnerPortNum = 0;
}