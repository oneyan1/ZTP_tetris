package logic.GameControl;

public class GameContext {
    GameState activity;

    public void setGameState(GameState activity){
        this.activity = activity;
    }

    public void changeGameState(){
        activity.changeGameState(this);
    }
}
