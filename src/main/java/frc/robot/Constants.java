/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /**
     * DRIVETRAIN CONSTANTS
     * 0 1 2 3 --> KITBOT, JANKBOT (Motor ports, in order)
     */
    public static final int leftMotor1Port = 0;
    public static final int leftMotor2Port = 1;
    public static final int rightMotor1Port = 2;
    public static final int rightMotor2Port = 3;

    public static final int leftEncoderChannelA = 0;
    public static final int leftEncoderChannelB = 1;
    public static final int rightEncoderChannelA = 2;
    public static final int rightEncoderChannelB = 3;

    public static final double speedScale = 0.8;
    public static final double minDrivePowerTurn = 0.35;

    public static final double minDrivePower = 0.1;
    public static final double maxDriveSpeed = 0.7;
    public static final double maxSpeed = 3;
    public static final double maxAcceleration = 3;

    // jank bot track width m
    public static final double trackWidth = 1;
    public static final DifferentialDriveKinematics kDriveKinematics =
            new DifferentialDriveKinematics(trackWidth);
    // These characterization values MUST be determined either experimentally or theoretically
    // for *your* robot's drive.
    // The Robot Characterization Toolsuite provides a convenient tool for obtaining these
    // values for your robot.
    public static final double ksVolts = 1.4124;

    public static final class OIConstants {
        public static final int xboxControllerPort = 0;
        public static final int fightStickPort = 1;
    }
    public static final double kvVoltSecondsPerMeter = 8.7779;
    public static final double kaVoltSecondsSquaredPerMeter = 1.9229;
    public static final DifferentialDriveVoltageConstraint autoVoltageConstraint = new DifferentialDriveVoltageConstraint(new SimpleMotorFeedforward(Constants.ksVolts, Constants.kvVoltSecondsPerMeter, Constants.kaVoltSecondsSquaredPerMeter), kDriveKinematics, 11.0);
    // ramesete params
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    // Example value only - as above, this must be tuned for your drive!
    public static final double kPDriveVel = 1.1035;
}
