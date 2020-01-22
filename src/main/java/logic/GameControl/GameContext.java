package logic.GameControl;

import java.awt.event.KeyEvent;

public class GameContext {
    StatusBar activity;

    public void setGameState(StatusBar activity){
        this.activity = activity;
    }

    public void drawStatusMesage(){
        activity.drawStatusMessage(this);
    }

    public void keyPressed(KeyEvent key){
        activity.keyPressed(key, this);
    }
}
