package logic.GameControl;

import logic.Board;

import java.awt.event.KeyEvent;

public class Paused implements StatusBar {
    Board board;
    public Paused(Board board) {
        this.board = board;
    }

    @Override
    public void drawStatusMessage(GameContext activity) {
        if (board.isPaused) {
            board.timer.stop();
            board.statusBar.setText("Paused");
            board.repaint();
            System.out.println("Stan - Paused");
        }
        else{
            activity.setGameState(new Running(board));
        }
    }

    @Override
    public void keyPressed(KeyEvent key, GameContext activity) {
        int keyCode = key.getKeyCode();
        if(keyCode == 'p' || keyCode == 'P'){
            board.isPaused = !board.isPaused;
            if(!board.isPaused){
                board.timer.start();
            }
        }
    }
}
