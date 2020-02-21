/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorDrive extends CommandBase {
    private final Elevator elevator;
    private final DoubleSupplier forward;
    private final DoubleSupplier side;
    private final DoubleSupplier throttle;
    private final BooleanSupplier trigger;


    public ElevatorDrive(Elevator elevatorInput, DoubleSupplier forwardInput, DoubleSupplier sideInput, DoubleSupplier throttleInput, BooleanSupplier triggerInput) {
        elevator = elevatorInput;
        forward = forwardInput;
        side = sideInput;
        throttle = throttleInput;
        trigger = triggerInput;
        addRequirements(elevator);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevator.driveElevator(forward.getAsDouble(), side.getAsDouble(), throttle.getAsDouble(), trigger.getAsBoolean(), 1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
