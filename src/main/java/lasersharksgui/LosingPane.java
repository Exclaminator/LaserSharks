package lasersharksgui;

import java.io.FileNotFoundException;
import java.io.IOException;

import lasersharks.Highscores;
import lasersharks.Logger;
import lasersharks.Options;
import lasersharks.RestartGameController;
import lasersharks.ScreenController;

/**
 * This pane represents the screen that is shown when a player loses.
 * 
 * @author Sytze
 *
 */
public class LosingPane extends StandardPane {

  /**
   * The constructor makes a new panel with a few text objects shown.
   * 
   * @throws FileNotFoundException
   */

  private static final double ADJUST_DY_FOR_BOTTOM = -400;
  private static final int CUSTOM_TEXT_SIZE = TEXT_SCALE_SIZE_SMALL + 10;

  public LosingPane() throws FileNotFoundException {
    if (Highscores.getInstance().getHighScore() < Highscores.getInstance().getScore()) {
      addMidText("NEW HIGHSCORE!", CUSTOM_TEXT_SIZE, ADJUST_DY_FOR_BOTTOM);
    }
    addMidText("YOU LOSE!", TEXT_SCALE_SIZE_BIG, Options.getGlobalHeight() / SCREEN_POSITION_THREE);
    String message;
    try {
      Highscores.getInstance().writeHighscore();
      message = Highscores.getInstance().makeHighscoreString();
    } catch (IOException e) {
      message = "Highscores failed to load";
      Logger.getInstance().write("IOException ", e.getMessage());
      e.printStackTrace();
    }
    addMidText(message, TEXT_SCALE_SIZE_SMALL, Options.getGlobalHeight() / SCREEN_POSITION_HUNDRED);
    addMidText("Press R to restart", TEXT_SCALE_SIZE_SMALL, -Options.getGlobalHeight()
        / SCREEN_POSITION_FIVE);
  }
}
