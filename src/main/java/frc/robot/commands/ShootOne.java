/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;


public class ShootOne extends CommandBase {
    private final Shooter shooter;
    private final Double speed;

    private final Timer shootTimer= new Timer();

    public ShootOne(Shooter shooter, Double speedInput) {
        this.shooter = shooter;
        speed = speedInput;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
      shootTimer.reset();
      shootTimer.start();
    }

    @Override
    public void execute() {
        shooter.shoot(speed);
    }


    @Override
    public boolean isFinished() {
      return (shootTimer.get() >= 1);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
        shootTimer.stop();
    }
}
