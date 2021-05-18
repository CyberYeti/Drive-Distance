// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase 
{
  private WPI_TalonFX leftLeader;
  private WPI_TalonFX leftFollower;
  private WPI_TalonFX rightLeader;
  private WPI_TalonFX rightFollower;
  

  public Drivetrain() 
  {
    //put canid in robot map
    leftLeader = new WPI_TalonFX(RobotMap.DriveTrainMap.LeftLeaderCanID);
    leftFollower = new WPI_TalonFX(RobotMap.DriveTrainMap.LeftFollowerCanID);
    rightLeader = new WPI_TalonFX(RobotMap.DriveTrainMap.rightLeaderCanID);
    rightFollower = new WPI_TalonFX(RobotMap.DriveTrainMap.rightFollowerCanID);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);

    leftLeader.setNeutralMode(NeutralMode.Brake);
    leftFollower.setNeutralMode(NeutralMode.Coast);
    rightLeader.setNeutralMode(NeutralMode.Brake);
    rightFollower.setNeutralMode(NeutralMode.Coast);

    leftLeader.setInverted(true);
    rightLeader.setInverted(false);
  }

  public void DirectPower(Double speed)
  {
    leftLeader.set(speed);
    rightLeader.set(speed);
  }

  public WPI_TalonFX GetLeftLeader()
  {
    return leftLeader;
  }

  public WPI_TalonFX GetRightLeader()
  {
    return rightLeader;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
