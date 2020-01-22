package logic.GameControl;


import java.awt.event.KeyEvent;

public interface StatusBar {
    void drawStatusMessage(GameContext activity);
    void keyPressed(KeyEvent key, GameContext activity);
}
