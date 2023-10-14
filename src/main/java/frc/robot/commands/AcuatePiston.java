// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.PnuematicSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AcuatePiston extends CommandBase {
  private final PnuematicSubsystem m_PnuematicSubsystem;

  /**
   * Creates a new Command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AcuatePiston(PnuematicSubsystem subsystem) {
    m_PnuematicSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_PnuematicSubsystem.isPistonDeployed()) {
      m_PnuematicSubsystem.undeployPiston();
    }
    else {
      m_PnuematicSubsystem.deployPiston();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
