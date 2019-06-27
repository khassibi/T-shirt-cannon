/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;
import frc.robot.OI;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem implements RobotMap{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static DriveTrain instance;
  private Talon front_left;
  private Talon front_right;;
  private Talon back_left;
  private Talon back_right;

  private DriveTrain(){
    front_left = new Talon(FRONT_LEFT_DRIVE);
    front_right = new Talon(FRONT_RIGHT_DRIVE);
    back_left = new Talon(BACK_LEFT_DRIVE);
    back_right = new Talon(BACK_RIGHT_DRIVE);
  }

  public static DriveTrain getInstance(){
    if(instance == null){
      instance = new DriveTrain();
    }
    return instance;
  }

  public void ManualDrive(){
    //insert driving logic 
    //ask someone how this works
    front_left.set(0.6*(OI.getInstance().getStick().getZ() - OI.getInstance().getStick().getY()));
    back_left.set(0.6*(OI.getInstance().getStick().getZ() - OI.getInstance().getStick().getY()));
    front_right.set(0.6*(OI.getInstance().getStick().getZ() + OI.getInstance().getStick().getY()));
    back_right.set(0.6*(OI.getInstance().getStick().getZ() + OI.getInstance().getStick().getY()));
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
}
