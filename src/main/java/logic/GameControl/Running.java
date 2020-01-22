package logic.GameControl;

import logic.Board;
import logic.Rotate.RotateLeft;
import logic.Rotate.RotateRight;

import java.awt.event.KeyEvent;

public class Running implements StatusBar {
    Board board;
    public Running(Board board){
        this.board = board;
    }
    @Override
    public void drawStatusMessage(GameContext activity) {
        if(!board.isPaused){
            board.statusBar.setText(String.valueOf(board.numLinesRemoved));
            board.repaint();
            System.out.println("stan - Runnig");
        }else{
            activity.setGameState(new Paused(board));
        }
    }

    @Override
    public void keyPressed(KeyEvent key, GameContext activity) {
        int keyCode = key.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_LEFT:
                board.tryMove(board.curPiece, board.curX-1, board.curY);
                break;
            case KeyEvent.VK_RIGHT:
                board.tryMove(board.curPiece, board.curX+1, board.curY);
                break;
            case KeyEvent.VK_DOWN:
                board.rotate = new RotateRight();
                board.tryMove(board.rotate.rotate(board.curPiece), board.curX, board.curY);
                break;
            case KeyEvent.VK_UP:
                System.out.println("up");
                board.rotate = new RotateLeft();
                board.tryMove(board.rotate.rotate(board.curPiece), board.curX, board.curY);
                break;
            case KeyEvent.VK_SPACE:
                board.dropDown();
                break;
            case 'd':
                board.oneLineDown();
                break;
            case KeyEvent.VK_P:
                System.out.println("pause");

                activity.setGameState(new Paused(board));
                break;
            case 'D':
                board.oneLineDown();
                break;

        }
    }
}
