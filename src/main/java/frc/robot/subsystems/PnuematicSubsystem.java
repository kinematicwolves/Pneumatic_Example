// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PnuematicSubsystem extends SubsystemBase {
  private final PneumaticHub m_PneumaticHub = new PneumaticHub(Constants.PnuematicConstants.PPNEUMATIC_HUB_ID);

  private final DoubleSolenoid m_pistonSolenoid = m_PneumaticHub.makeDoubleSolenoid(
    Constants.PnuematicConstants.SOL_FWD, Constants.PnuematicConstants.SOL_RVS);

  private boolean pistonIsDeployed = false;

  /** Creates a new ExampleSubsystem. */
  public PnuematicSubsystem() {
    enableCompressor();
  }

  public boolean isPistonDeployed() {
    return pistonIsDeployed;
  }

  public void enableCompressor() {
    m_PneumaticHub.enableCompressorDigital();
  }

  public void deployPiston() {
    m_pistonSolenoid.set(Value.kForward);
    pistonIsDeployed = true;
  }

  public void undeployPiston() {
    m_pistonSolenoid.set(Value.kReverse);
    pistonIsDeployed = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
