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
            board.timer.stop();
            board.statusBar.setText("Paused");
            board.repaint();
            System.out.println("Stan - Paused");
    }

    @Override
    public void keyPressed(KeyEvent key, GameContext activity) {
        int keyCode = key.getKeyCode();
        if(keyCode == 'p' || keyCode == 'P'){
            board.timer.start();
            activity.setGameState(new Running(board));
        }
    }
}
