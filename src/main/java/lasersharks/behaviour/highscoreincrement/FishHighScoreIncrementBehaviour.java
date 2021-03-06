package lasersharks.behaviour.highscoreincrement;

import lasersharks.behaviour.HighScoreIncrementBehaviour;
import lasersharks.interfaces.Displayable;

/**
 * High score Increment behaviour for SeaObjects.
 *
 * @author SEMGroup27
 */
public class FishHighScoreIncrementBehaviour implements HighScoreIncrementBehaviour {
  private final Displayable element;

  /**
   * Constructor.
   *
   * @param element object for which to act.
   */
  public FishHighScoreIncrementBehaviour(final Displayable element) {
    this.element = element;
  }

  @Override
  public int onCollisionHighScoreIncrement() {
    return (int) Math.max(element.getSize() + element.getSpeed(), 0);
  }
}
