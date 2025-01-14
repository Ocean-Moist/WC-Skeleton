/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.auto.AutoForwardDistance;
import frc.robot.commands.auto.FollowExampleTraj;
import frc.robot.commands.drive.DriveTank;
import frc.robot.lib.ResetEncoderValues;
import frc.robot.lib.RobotType;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    private static final RobotType ROBOT_TYPE = RobotType.JANKBOT; //TODO CHANGE THIS FOR THE ROBOT YOU ARE DEPLOYING TO
    public static JoystickButton xboxA;
    public static JoystickButton xboxB;
    public static JoystickButton xboxX;
    public static JoystickButton xboxY;
    public static JoystickButton xboxLB; // Define all the xbox buttons and left trigger stick
    public static JoystickButton xboxRB;
    public static JoystickButton xboxSquares;
    public static JoystickButton xboxBurger;
    public static Trigger xboxLS;
    public static XboxController.Axis xboxRS;

    public static XboxController xboxController = new XboxController(Constants.OIConstants.xboxControllerPort);

    SendableChooser<Command> chooser = new SendableChooser<>();
    private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem(ROBOT_TYPE);
    //private final LimeLightSubsystem limelight = new LimeLightSubsystem("limelight-two");


  public RobotContainer() {
      buttonSetup(); // Once the robot is initialized, configure and setup all xbox buttons
      configureButtonBindings();
      SmartDashboard.putData("AutoChooser", chooser);
      chooser.setDefaultOption("AutoRoutine6", new FollowExampleTraj(drivetrain));


      drivetrain.setDefaultCommand(new DriveTank(drivetrain, xboxController)); // Automatically assign DriveArcade to the xbox controller
  }

  private void buttonSetup() {
      xboxA = new JoystickButton(xboxController, 1);
      xboxB = new JoystickButton(xboxController, 2);
      xboxX = new JoystickButton(xboxController, 3);
      xboxY = new JoystickButton(xboxController, 4);
      xboxLB = new JoystickButton(xboxController, 5);
      xboxRB = new JoystickButton(xboxController, 6);
      xboxSquares = new JoystickButton(xboxController, 7);
      xboxBurger = new JoystickButton(xboxController, 8);
      xboxLS = new Trigger();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // Once you have more subsystems, use this function to assign buttons to their activation
      xboxA.whenPressed(new AutoForwardDistance(drivetrain, 2));
      xboxX.whenPressed(new ResetEncoderValues(drivetrain));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}
