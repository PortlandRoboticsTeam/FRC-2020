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
    public static final int wheel1PortNum = 5;  //front right
    public static final int wheel2PortNum = 6;  //rear right
    public static final int wheel3PortNum = 1;  //front left
    public static final int wheel4PortNum = 2;  //rear left
    public static final int wheel5PortNum = 3;  //center one
    public static final int wheel6PortNum = 4;  //center two

    //PWM port numberings
    public static final int elevator1PortNum = 7;
    public static final int elevator2PortNum = 7;
    public static final int intakePortNum = 0;
    public static final int shooterBottomPortNum = 8;
    public static final int shooterTopPortNum = 9;
    public static final int wheelSpinnerPortNum = 11;

    public static final int mStickPort = 0;
    public static final int sStickPort = 1;
}