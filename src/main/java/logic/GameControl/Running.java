package logic.GameControl;

import logic.Board;

public class Running implements GameState {
    Board board;

    public Running(Board board){
        this.board = board;
    }
    @Override
    public void changeGameState(GameContext activity) {
        if(!board.isPaused){
            //board.timer.start();
            board.statusBar.setText(String.valueOf(board.numLinesRemoved));
            board.repaint();
            System.out.println("stan - Runnig");
        }else{
            activity.setGameState(new Paused(board));
        }
    }
}
