/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.RobotMap;
import frc.robot.commands.Shoot;


/**
 * Add your docs here.
 */
public class Shooter extends Subsystem implements RobotMap{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static Shooter instance;
  private Timer timer;
  private Solenoid solenoid;

  public static Shooter getInstance(){
    if(instance == null){
      instance = new Shooter();
    }
    return instance;
  }
  
  private Shooter(){
    timer = new Timer();
    solenoid = new Solenoid(SHOOTER_SOLENOID);
  }

  public void startTime(){
    timer.reset();
    timer.start();
  }

  public void open(){
    solenoid.set(true);
  }

  public void close(){
    solenoid.set(false);
  }

  public boolean isDone(double finTIme){
    if(timer.get() >= finTIme){
      timer.start();
      return true;
    }
    return false;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Shoot());
  }
}
