package lasersharks;

import java.io.IOException;
import java.util.List;

import javafx.scene.Scene;
import lasersharksgui.GamePane;
import lasersharksgui.LosingPane;
import lasersharksgui.MainGui;
import lasersharksgui.WinPane;

/**
 * This is the class that will manage the screen.
 * 
 * @author Youri
 *
 */
@SuppressWarnings("restriction")
public class ScreenController {
  private GamePane currentPane;
  private FishController fishCon;
  private static final int GAME_WINNING_SIZE = 320;

  /**
   * Constructor.
   * @param pane 
   *          the GamePane this screencontroller is set to
   */
  public ScreenController(GamePane pane) {
    super();
    this.fishCon = new FishController();
    this.currentPane = pane;
    this.currentPane.setScreenController(this);
  }


  /**
   * Get information for next frame and checks if the shark is bigger than the winning size.
   * 
   * @param frametime
   *          time between frames in seconds
   * 
   * @return FishInfo
   * @throws IOException 
   */
  public List<Swimmer> getNextFrameInfo(double frametime) throws IOException {
    if (MainGui.getInstance().getCurrentPane() instanceof GamePane) {
      GamePane gamePane = (GamePane) MainGui.getInstance().getCurrentPane();
      if (!this.fishCon.getShark().isAlive()) {
        MainGui.browseToGlobal(LosingPane.class);
        gamePane.stopGame();
      } else if (this.fishCon.getShark().getSize() > GAME_WINNING_SIZE) {
        MainGui.browseToGlobal(WinPane.class);
        gamePane.stopGame();
      }
    }

    return this.fishCon.getNextCycleInformation(frametime);
  }

  /**
   * get the shark from the level.
   * 
   * @return the shark
   */
  public LaserShark getShark() {
    return this.fishCon.getShark();
  }

  /**
   * Propagation function for starting the game.
   */
  public void start() {
    this.currentPane.startGame();
  }

  /**
   * @return the scene used for this screencontroller.
   */
  public Scene getGlobalScene() {
    return MainGui.getInstance().getCurrentScene();
  }
  
  /**
   * Restart the game.
   * @throws IOException 
   */
  public void restart() throws IOException {
    this.currentPane.stopGame();
    this.currentPane.restartGame();
    this.fishCon.getShark().setAlive();
    this.fishCon.clearFish();
    this.fishCon.getShark().setSize(fishCon.getStartSize());    
    Highscores.setScore(0);    
    //MainGui.browseToGlobal(GamePane.class);
    this.currentPane.resumeGame();
  }

}
