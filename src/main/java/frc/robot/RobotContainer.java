/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.drive.DriveArcade;
import frc.robot.commands.drive.DriveTank;
import frc.robot.commands.drive.FastTurnSpeed;
import frc.robot.commands.drive.SlowTurnSpeed;
import frc.robot.lib.RobotType;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    private static final RobotType ROBOT_TYPE = RobotType.KITBOT;
    public static JoystickButton xboxA;
    public static JoystickButton xboxB;
    public static JoystickButton xboxX;
    public static JoystickButton xboxY;
    public static JoystickButton xboxLB;
    public static JoystickButton xboxRB;
    public static JoystickButton xboxSquares;
    public static JoystickButton xboxBurger;
    public static Trigger xboxLS;
    public static XboxController.Axis xboxRS;

    public static XboxController xboxController = new XboxController(Constants.OIConstants.xboxControllerPort);

    private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem(ROBOT_TYPE);


  public RobotContainer() {
      buttonSetup();
      configureButtonBindings();

      drivetrain.setDefaultCommand(new DriveArcade(drivetrain, xboxController));
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
  //    xboxRS = new Ax();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    xboxY.whenPressed(new FastTurnSpeed());
    xboxX.whenPressed(new SlowTurnSpeed());

    xboxLS.whenActive(new DriveArcade(drivetrain, xboxController));

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}