package logic.GameControl;

import logic.Board;

public class Paused implements GameState {
    Board board;
    public Paused(Board board) {
        this.board = board;
    }

    @Override
    public void changeGameState(GameContext activity) {
        if (board.isPaused) {
            board.timer.stop();
            board.statusBar.setText("Paused");
            //board.repaint();
        }
        else{
            activity.setGameState(new Running(board));
        }
    }
}
