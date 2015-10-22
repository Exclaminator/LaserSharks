package lasersharks.behaviour.ammunitionIncrement;

import lasersharks.Options;
import lasersharks.behaviour.AmmunitionIncrementBehaviour;
import lasersharks.controllers.AudioController;

/**
 * Ammunition increment behaviour for Ammunition.
 * 
 * @author SEMGroup27
 *
 */
public class AmmoAmmunitionIncrementBehaviour implements AmmunitionIncrementBehaviour {
  private static final int AMMUNITION_SIZE = 10;

  @Override
  public synchronized int onCollisionAmmunitionIncrement() {
    AudioController.getInstance()
        .playSoundEffect(Options.getInstance().getAmmoPickupSoundFileName());
    return AMMUNITION_SIZE;
  }
}
