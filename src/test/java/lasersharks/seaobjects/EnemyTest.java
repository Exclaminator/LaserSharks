package lasersharks.seaobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import lasersharks.seaobjects.Enemy;

/**
 * The test for the enemy1 class.
 * 
 * @author SEMGroup27
 *
 */
public class EnemyTest extends SeaObjectTest {
  private static final String IMAGE = "enemy-1.png";

  /**
   * Run the test on correct item.
   */
  @Before
  public void setUp() {
    this.fish1 = new Enemy(IMAGE, 1, 1, this.posOnScreen, Float.valueOf(this.size),
        Double.valueOf(this.speed), this.direction);
  }

  /**
   * See if proper image is being used.
   */
  @Test
  public void testImage() {
    assertEquals(IMAGE, this.fish1.getImageResource());
  }
}