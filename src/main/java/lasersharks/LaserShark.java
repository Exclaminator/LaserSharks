package lasersharks;

import lasersharksgui.MainGui;
import lasersharksgui.StandardPane;

/**
 * LaserShark class.
 *
 */
public class LaserShark extends Fish implements DirectionCallback {

  private final String imageResource = "shark.png";
  private final float widthScale = 1.5f;

  /**
   * Constructor class for FishBot.
   * 
   * @param position
   *          initial position
   * @param size
   *          init size
   * @param startSpeed
   *          init speed
   * @param direction
   *          init direction
   */
  public LaserShark(Position position, float size, double startSpeed, Direction direction) {
    super(position, size, startSpeed, direction);
    collisionBehaviour = new DefaultCollisionBehaviour(this);
    hitboxBehaviour = new DefaultHitboxBehaviour(this);
    moveBehaviour = new SharkMoveBehaviour(this);
    eatBehaviour = new DefaultEatBehaviour(this);
  }

  @Override
  public String getImageResource() {
    return imageResource;
  }

  @Override
  public double getWidthScale() {
    return widthScale;
  }

  @Override
  public void setDirection(Direction dir) {
    if (this.isAlive() && this.getDirection() != dir) {
      Logger.getInstance().write("Change of direction",
          "From: " + this.getDirection() + ", to: " + dir);
    }
    super.setDirection(dir);
  }

  @Override
  public void kill() {
    Logger.getInstance().write("Loss", "Player has colided with a bigger fish");
    super.kill();
  }

  @Override
  public void putDirection(Direction dir) {
    this.setDirection(dir);
  }
}
