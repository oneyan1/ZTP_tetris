package logic;

import windows.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private static final int BOARD_HEIGHT = 22;
    private static final int BOARD_WIDTH = 10;
    private static final Color[] COLORS = {new Color(0,0,0), new Color(204, 102, 102),
        new Color(102,204,102), new Color(102,102,204), new Color(204,204, 102),
        new Color(204,102,204), new Color(102,204,204), new Color(218, 170, 0)};
    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isStarted = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusBar;
    private Shape curPiece;
    private Tetrominos[] board;

    public Board(GameFrame frame){
        setFocusable(true);
        curPiece = new Shape();
        timer = new Timer(400, this);
        statusBar = frame.getStatusbar();
        board = new Tetrominos[BOARD_HEIGHT * BOARD_WIDTH];
        clearBoard();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(isFallingFinished){
            isFallingFinished = false;
            newPiece();
        }else{
            oneLineDown();
        }
    }

    public int squareWidth(){
        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    public int squareHeight(){
        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    public Tetrominos shapeAt(int x, int y){
        return board[y * BOARD_WIDTH + x];
    }

    public void clearBoard(){
        for (int i = 0; i < BOARD_WIDTH * BOARD_HEIGHT ; i++) {
            board[i] = Tetrominos.NO_SHAPE;
        }
    }

    private void pieceDropped(){
        for (int i = 0; i < 4; i++) {
            int x = curX + curPiece.getX(i);
            int y = curY - curPiece.getY(i);
            board[y * BOARD_WIDTH + x] = curPiece.getShape();
        }
        if(!isFallingFinished){
            newPiece();
        }
    }

    public void newPiece(){
        curPiece.setRandomShape();
        curX = BOARD_WIDTH / 2 + 1;
        curY = BOARD_HEIGHT - 1 + curPiece.minX();
    }

    private void oneLineDown(){
        pieceDropped();
    }

    private void drawSquare(Graphics g, int x, int y, Tetrominos shape){
        Color color = COLORS[shape.ordinal()];
        g.setColor(color);
        g.fillRect(x+1, y+1, squareWidth()-2, squareHeight()-2);
        g.setColor(color.brighter());
        g.drawLine(x, y+squareHeight()-1, x, y);
        g.drawLine(x, y, x+squareHeight()-1, y);
        g.setColor(color.darker());
        g.drawLine(x+1, y+squareHeight()-1, x+squareWidth()-1, y + squareHeight()-1);
        g.drawLine(x+squareWidth()-1, y+squareHeight()-1, x+squareWidth()-1, y+1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; ++j) {
                Tetrominos shape = shapeAt(j , BOARD_HEIGHT-i-1);

                if(shape != Tetrominos.NO_SHAPE){
                    drawSquare(g, j*squareWidth(), boardTop+i*squareHeight(), shape);
                }
            }
        }
        if(curPiece.getShape() != Tetrominos.NO_SHAPE){
            for (int i = 0; i < 4; ++i) {
                int x = curX + curPiece.getX(i);
                int y = curY + curPiece.getY(i);
                drawSquare(g, x*squareWidth(), boardTop + (BOARD_HEIGHT - y -1)*squareHeight(), curPiece.getShape());
            }
        }
    }
}
