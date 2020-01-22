package logic.GameControl;

import logic.Board;

public class Paused implements GameState {
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
}
