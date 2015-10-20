package lasersharks.enemies;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import lasersharks.FishBotTest;
import lasersharks.seaObjects.Fish;

/**
 * The test for the enemy1 class.
 * 
 * @author SEMGroup27
 *
 */
public class EnemyTest extends FishBotTest {
  private static final String IMAGE = "enemy-1.png";
  /**
   * Run the test on correct item.
   */
  @Before
  public void setUp() {
    this.fish1 = new Fish(
        IMAGE,
        1,
        1,
        this.posOnScreen,
        Float.valueOf(this.size),
        Double.valueOf(this.speed),
        this.direction
    );
  } 
  
  /**
   * See if proper image is being used.
   */
  @Test
  public void testImage() {
    assertEquals(IMAGE, this.fish1.getImageResource());
  }
}