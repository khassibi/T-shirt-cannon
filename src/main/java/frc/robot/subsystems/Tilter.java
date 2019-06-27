/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * Add your docs here.
 */
public class Tilter extends Subsystem implements RobotMap{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Tilter instance;
  private Talon tiltMotor;
  private Timer timer;

  private Tilter(){
    tiltMotor = new Talon(WINDOW_MOTOR);
    //there might be a good reason to use a timer but the code currently doesn't have anything
    timer = new Timer();
  }

  public static Tilter getInstance(){
    if(instance == null){
      instance = new Tilter();
    }
    return instance;
  }

  public void angleUp(){
    tiltMotor.set(0.5);
  }

  public void angleDown(){
    tiltMotor.set(-0.5);
  }

  public void stop(){
    tiltMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    //when a subsystem has more than one command linked to it, you don't set a default command
    //you don't always need to set a default command 
  }
}
