// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class RobotMap 
{
    public class DriveTrainMap
    {
        public static final double inchesPerTicks = (18.0f/28.0f) * (10.0f/64.0f) * 6.0f * Math.PI * (1.0f/2048.0f);
        public static final int LeftLeaderCanID = 0;
        public static final int LeftFollowerCanID = 1;
        public static final int rightLeaderCanID = 2;
        public static final int rightFollowerCanID = 3;

    }
}
