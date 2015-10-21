package lasersharks.behaviour.collision;

import lasersharks.behaviour.interfaces.CollisionBehaviour;
import lasersharks.interfaces.Displayable;

public class SharkCollisionBehaviour implements CollisionBehaviour{
  Displayable object;
  
  /**
   * Constructor.
   * @param me this.
   */
  public SharkCollisionBehaviour(Displayable me) {
    super();
    this.object = me;
  }

  @Override
  public void colideWith(Displayable other) {
    System.out.println("Collide with is called on" + other.getClass().getName());
    other.onCollisionPlayerLoses(object.getSize());
    object.increaseSize(other.onCollisionSizeIncrement());
    object.increaseAmmunition(other.onCollisionAmmunitionIncrement());
    other.onCollisionEaten();
    
    
  }
  
}
