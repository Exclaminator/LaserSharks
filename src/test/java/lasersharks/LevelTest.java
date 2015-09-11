package lasersharks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import lasersharks.gui.LevelGUI;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import javafx.scene.Scene;

/**
 * Testclass for Level class.
 * @author Youri
 *
 */
public class LevelTest {
  private Level level;
  private Game game;
  private LevelGUI levelGUI;
  
  /**
   * Setup all classes and mocks for testing.
   */
  @Before
  @SuppressWarnings("restriction")
  public void setUp() {
    this.game = mock(Game.class);
    this.levelGUI = mock(LevelGUI.class);
    Scene sc = mock(Scene.class);
    when(this.levelGUI.getScene()).thenReturn(sc);
    
    this.level = new Level(this.game, this.levelGUI);
  }

  /**
   * Test fishCon getter.
   */
  @Test
  public void testGetFishCon() {
    assertTrue(this.level.getFishCon() != null);
  }
  
  /**
   * Make sure the getter functions properly.
   */
  @Test
  public void testSetFishCon() {
    FishController fc = mock(FishController.class);
    this.level.setFishCon(fc);
    assertEquals(fc, this.level.getFishCon());
  }
  
  /**
   * Make sure the nextCyleInformation propagates properly.
   */
  @Test
  public void testNextCycleInformation() {
    FishController fc = mock(FishController.class);
    this.level.setFishCon(fc);
    this.level.getNextFrameInfo();
    verify(fc).getNextCycleInformation();
  }
  
  /**
   * Make sure the shark request is propagated to the correct source.
   */
  @Test
  public void testGetShark() {
    assertTrue(this.level.getShark() != null);
  }
  

  /**
   * Test fishCon getter.
   */
  @Test
  public void testGetScreenCon() {
    assertTrue(this.level.getScreenCon() != null);
  }
  
  /**
   * Make sure the getter functions properly.
   */
  @Test
  public void testSetScreenCon() {
    ScreenController sc = mock(ScreenController.class);
    this.level.setScreenCon(sc);
    assertEquals(sc, this.level.getScreenCon());
  }

  /**
   * Test to see if shark is a non null object.
   */
  @Test
  public void getSharkTest() {
    assertTrue(this.level.getShark() != null);
  }

  /**
   * Test to see if setShark work correctly.
   */
  @Test
  public void setSharkTest() {
    LaserShark ls = mock(LaserShark.class);
    this.level.setShark(ls);
    assertEquals(ls, this.level.getShark());
  }
  
  /**
   * Test to see if set SharkDirection functions properly.
   */
  @Test
  public void testSetSharkDirection() {
    Direction dr = Direction.None;
    LaserShark ls = mock(LaserShark.class);
    this.level.setShark(ls);
    this.level.setSharkDirection(dr);
    verify(ls).setDirection(dr);
  }
  
  /**
   * Make sure default keyboard controller != null.
   */
  @Test
  public void testGetKeyboardController() {
    assertTrue(this.level.getKeyboardCon() != null);
  }
  
  /**
   * Test the keyboardcontroller getter.
   */
  @Test
  public void testSetKeyboardController() {
    KeyboardController kbc = mock(KeyboardController.class);
    this.level.setKeyboardCon(kbc);
    assertEquals(kbc, this.level.getKeyboardCon());
  }
  
  /**
   * Make sure default game != null.
   */
  @Test
  public void testGetGame() {
    assertTrue(this.level.getGame() != null);
  }
  
  /**
   * Test the game getter.
   */
  @Test
  public void testSetGame() {
    Game game = mock(Game.class);
    this.level.setGame(game);
    assertEquals(game, this.level.getGame());
  }
  
  /**
   * Test launch method.
   */
  @Test
  public void testLaunch() {
    System.out.println(this.level);
    ScreenController sc = mock(ScreenController.class);
    this.level.setScreenCon(sc);
    this.level.launch();
    verify(sc).start();
  }
}
