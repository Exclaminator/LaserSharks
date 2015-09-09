package lasersharks;


import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;


/**
 * Class for testing Fish object.
 * @author Stefan
 *
 */
public abstract class FishTest {

  protected Fish fish1;
  protected final Position posOnScreen = new Position(50, 50);
  protected final Position posOffScreen = new Position(-1, -1);
  protected final float size = 30;
  protected final int speed = 40;
  protected final Direction direction = Direction.East;


  /**
   * Tear down the fish Object after the test.
   */
  @After
  public void tearDown() {
    fish1 = null;
  }

  /**
   * Test for {@link Fish#getPosition()}.
   */
  @Test
  public void testGetPosition() {
    assertEquals(posOnScreen, fish1.getPosition());
  }

  /**
   * Test for {@link Fish#getSize()}.
   */
  @Test
  public void testGetSize() {
    assertTrue(fish1.getSize() == size);
  }

  /**
   * Test for {@link Fish#increaseSize(Float)}.
   */
  @Test
  public void testIncreaseSize() {
    int deltaSize = 2;
    fish1.increaseSize(deltaSize);
    assertEquals(size + deltaSize, fish1.getSize(), 0);
  }

  /**
   * Test for {@link Fish#getSpeed()}.
   */
  @Test
  public void testGetSpeed() {
    assertTrue(fish1.getSpeed() == speed);
  }

  /**
   * Test for {@link Fish#setSpeed(int)}.
   */
  @Test
  public void testSetSpeed() {
    int newSpeed = 2;
    fish1.setSpeed(newSpeed);
    assertEquals(newSpeed, fish1.getSpeed());
  }

  /**
   * Test for {@link Fish#getDirection()}.
   */
  @Test
  public void testGetDirection() {
    assertEquals(fish1.getDirection(), Direction.East);
  }
  /**
   * Test for {@link Fish#setDirection(Direction)}.
   */
  @Test
  public void testSetDirection() {
    Direction newDirection = Direction.South;
    fish1.setDirection(newDirection);
    assertEquals(fish1.getDirection(), newDirection);
  }

  /**
   * Test for {@link Fish#collision(Fish)}.
   */
  @Test
  public void testCollisionTrue() {
    Fish mockedFish = mock(Fish.class);
    when(mockedFish.getPosition()).thenReturn(posOnScreen);
    when(mockedFish.getSize()).thenReturn(size);
    assertTrue(fish1.collision(mockedFish));
  }

  /**
   * Test for {@link Fish#collision(Fish)}.
   */
  @Test
  public void testCollisionFalse() {
    Fish mockedFish = mock(Fish.class);
    when(mockedFish.getPosition()).thenReturn(posOffScreen);
    when(mockedFish.getSize()).thenReturn(size);
    assertFalse(fish1.collision(mockedFish));
  }

  /**
   * Test for {@link Fish#move()}.
   */
  @Test
  public void testMove() {
    int oldX = fish1.getPosition().getPosX();
    fish1.move();
    int newX = fish1.getPosition().getPosX();
    assertEquals(oldX + fish1.getSpeed(), newX);
  }

}