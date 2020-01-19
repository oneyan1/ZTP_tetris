package states;

import java.awt.*;

public class Game {

    private GameState homeScreen;
    private GameState running;
    private GameState paused;

    private GameState gameState;

    public Game(){
        homeScreen = new HomeScreen();
        running = new Running();
        paused = new Paused();

        gameState = homeScreen;
    }

    void setMuchaState(GameState newGameState) {
        gameState = newGameState;
    }

    public void draw() {
        gameState.draw();
    }

    public void update() {
        gameState.update();
    }
}
