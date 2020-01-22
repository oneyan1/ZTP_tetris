package logic.GameControl;

public class GameContext {
    StatusBar activity;

    public void setGameState(StatusBar activity){
        this.activity = activity;
    }

    public void drawStatusMesage(){
        activity.drawStatusMessage(this);
    }
}
