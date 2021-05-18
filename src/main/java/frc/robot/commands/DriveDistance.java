// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.RobotMap;

public class DriveDistance extends CommandBase {
  /** Creates a new DriveDistance. */
  private final Drivetrain drivetrain;

  private double targetDistance;
  private double inchesPerTicks;

  private boolean isDone = false;
  

  public DriveDistance(double _targetDistance) 
  {
    targetDistance = _targetDistance;

    drivetrain = new Drivetrain();
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    inchesPerTicks = RobotMap.DriveTrainMap.inchesPerTicks;
    drivetrain.GetLeftLeader().setSelectedSensorPosition(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double distanceTraveled = drivetrain.GetLeftLeader().getSelectedSensorPosition() * inchesPerTicks;
    drivetrain.DirectPower(0.2);

    if(distanceTraveled >= targetDistance)
    {
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    drivetrain.DirectPower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
