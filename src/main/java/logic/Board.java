package logic;

import windows.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private static final int BOARD_HEIGHT = 22;
    private static final int BOARD_WIDTH = 10;
    private static final Color[] COLORS = {new Color(0, 0, 0), new Color(204, 102, 102),
            new Color(102, 204, 102), new Color(102, 102, 204), new Color(204, 204, 102),
            new Color(204, 102, 204), new Color(102, 204, 204), new Color(218, 170, 0)};
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

    public Board(GameFrame frame) {
        setFocusable(true);
        curPiece = new Shape();
        timer = new Timer(400, this);
        statusBar = frame.getStatusbar();
        board = new Tetrominos[BOARD_HEIGHT * BOARD_WIDTH];
        clearBoard();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isFallingFinished) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }

    public int squareWidth() {
        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    public int squareHeight() {
        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    public Tetrominos shapeAt(int x, int y) {
        return board[y * BOARD_WIDTH + x];
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_WIDTH * BOARD_HEIGHT; i++) {
            board[i] = Tetrominos.NO_SHAPE;
        }
    }

    private void pieceDropped() {
        for (int i = 0; i < 4; i++) {
            int x = curX + curPiece.getX(i);
            int y = curY - curPiece.getY(i);
            board[y * BOARD_WIDTH + x] = curPiece.getShape();
        }
        removeFullLines();
        if (!isFallingFinished) {
            newPiece();
        }
    }

    public void newPiece() {
        curPiece.setRandomShape();
        curX = BOARD_WIDTH / 2 + 1;
        curY = BOARD_HEIGHT - 1 + curPiece.minX();

        if(!tryMove(curPiece, curX, curY-1)){
            curPiece.setShape(Tetrominos.NO_SHAPE);
            timer.stop();
            isStarted = false;
            statusBar.setText("Game over");
        }
    }

    private void oneLineDown() {
        if(!tryMove(curPiece, curX, curY-1)){
            pieceDropped();
        }
    }

    private void drawSquare(Graphics g, int x, int y, Tetrominos shape) {
        Color color = COLORS[shape.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareHeight() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; ++j) {
                Tetrominos shape = shapeAt(j, BOARD_HEIGHT - i - 1);

                if (shape != Tetrominos.NO_SHAPE) {
                    drawSquare(g, j * squareWidth(), boardTop + i * squareHeight(), shape);
                }
            }
        }
        if (curPiece.getShape() != Tetrominos.NO_SHAPE) {
            for (int i = 0; i < 4; ++i) {
                int x = curX + curPiece.getX(i);
                int y = curY + curPiece.getY(i);
                drawSquare(g, x * squareWidth(), boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(), curPiece.getShape());
            }
        }
    }

    public void start() {
        if (isPaused) return;
        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        clearBoard();
        newPiece();
        timer.start();
    }

    public void pause() {
        if (!isStarted) return;
        isPaused = !isPaused;
        if (isPaused) {
            timer.stop();
            statusBar.setText("Paused");
        } else {
            timer.start();
            statusBar.setText(String.valueOf(numLinesRemoved));
        }
        repaint();
    }

    public boolean tryMove(Shape newPiece, int newX, int newY) {
        for (int i = 0; i < 4; i++) {
            int x = newX + newPiece.getX(i);
            int y = newY + newPiece.getY(i);

            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) return false;
            if (shapeAt(x, y) != Tetrominos.NO_SHAPE) return false;
        }
        curPiece = newPiece;
        curX = newX;
        curY = newY;
        repaint();
        return true;
    }

    private void removeFullLines(){
        int numFullLines = 0;
        for (int i = BOARD_HEIGHT-1; i >= 0; --i) {
            boolean linesIsFull = true;
            for (int j = 0; j < BOARD_WIDTH; ++j) {
                if(shapeAt(j, i) == Tetrominos.NO_SHAPE){
                    linesIsFull = false;
                    break;
                }
            }
            if(linesIsFull){
                ++numFullLines;
                for (int k = i; k < BOARD_HEIGHT - 1 ; ++k) {
                    for (int j = 0; j < BOARD_WIDTH; ++j) {
                        board[k * BOARD_WIDTH + j] = shapeAt(j, k+1);
                    }
                }
            }
            if(numFullLines > 0){
                numLinesRemoved += numFullLines;
                statusBar.setText(String.valueOf(numLinesRemoved));
                isFallingFinished = true;
                curPiece.setShape(Tetrominos.NO_SHAPE);
                repaint();
            }
        }
    }

    private void dropDown(){
        int newY = curY;
        while(newY > 0){
            if(!tryMove(curPiece, curX, newY-1)) break;
            --newY;
        }
        pieceDropped();
    }

}
