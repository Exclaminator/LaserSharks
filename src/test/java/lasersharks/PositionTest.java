package lasersharks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan .
 *
 */
public class PositionTest {

  private static final int POSITION_Y = 5;
  private static final int POSITION_X = 5;
  private Position position;
  private int posX;
  private int posY;

  /**
   * Make sure the test has the same variables each time.
   */
  @Before
  public void setUp() {
    posX = 0;
    posY = 0;
    position = new Position(posX, posY);
  }

  /**
   * Test method for {@link lasersharks.Position#getPosX()}.
   */
  @Test
  public void testGetPosX() {
    assertEquals(posX, position.getPosX());
  }

  /**
   * Test method for {@link lasersharks.Position#setPosX(int)}.
   */
  @Test
  public void testSetPosX() {
    position.setPosX(POSITION_X);
    assertEquals(POSITION_X, position.getPosX());
  }

  /**
   * Test method for {@link lasersharks.Position#adjustPosX(int)}.
   */
  @Test
  public void testAdjustPosX() {
    assertEquals(posX, position.getPosX());
    // Delta 1
    position.adjustPosX(1);
    assertEquals(posX + 1, position.getPosX());
    // Delta -1
    position.adjustPosX(-1);
    assertEquals(posX, position.getPosX());
  }

  /**
   * Test method for {@link lasersharks.Position#getPosY()}.
   */
  @Test
  public void testGetPosY() {
    assertEquals(posY, position.getPosY());
  }

  /**
   * Test method for {@link lasersharks.Position#setPosY(int)}.
   */
  @Test
  public void testSetPosY() {
    position.setPosY(POSITION_Y);
    assertEquals(POSITION_Y, position.getPosY());
  }

  /**
   * Test method for {@link lasersharks.Position#adjustPosY(int)}.
   */
  @Test
  public void testAdjustPosY() {
    assertEquals(posY, position.getPosY());
    // Delta 1
    position.adjustPosY(1);
    assertEquals(posY + 1, position.getPosY());
    // Delta -1
    position.adjustPosY(-1);
    assertEquals(posY, position.getPosY());
  }

  /**
   * Test method for {@link lasersharks.Position#adjustPos(int, int)}.
   */
  @Test
  public void testAdjustPos() {
    assertEquals(posX, position.getPosY());
    assertEquals(posY, position.getPosY());
    // Delta x 1
    position.adjustPos(1, 0);
    assertEquals(posX + 1, position.getPosX());
    assertEquals(posY, position.getPosY());
    // Delta x -1
    position.adjustPos(-1, 0);
    assertEquals(posX, position.getPosX());
    assertEquals(posY, position.getPosY());
    // Delta y 1
    position.adjustPos(0, 1);
    assertEquals(posX, position.getPosX());
    assertEquals(posY + 1, position.getPosY());
    // Delta y -1
    position.adjustPos(0, -1);
    assertEquals(posX, position.getPosX());
    assertEquals(posY, position.getPosY());
  }

  /**
   * Test method for {@link lasersharks.Position#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObjectTrue() {
    Position testPosition = new Position(0, 0);
    assertTrue(position.equals(testPosition));
    assertTrue(position.equals(position));
  }

  /**
   * Test method for {@link lasersharks.Position#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObjectFalse1() {
    assertFalse(position.equals(new Position(1, 0)));
  }
  
  /**
   * Test method for {@link lasersharks.Position#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObjectFalse2() {
    assertFalse(position.equals(new Position(0, 1)));
  }
  
  /**
   * Test method for {@link lasersharks.Position#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObjectFalse3() {
    assertFalse(position.equals(new Position(1, 1)));
  }

  /**
   * Test method for {@link lasersharks.Position#hashCode()}.
   */
  @Test
  public void testHashCode() {
    Position testPosition = new Position(0, 0);
    assertTrue(position.hashCode() == testPosition.hashCode());
    testPosition = new Position(1, 1);
    assertTrue(position.hashCode() != testPosition.hashCode());
  }
}
