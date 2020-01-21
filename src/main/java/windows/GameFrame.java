package windows;

import logic.Board;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JLabel statusbar;

    public GameFrame(){
        statusbar = new JLabel("0");
        add(statusbar, BorderLayout.SOUTH);
        Board board = new Board(this);
        add(board);

        board.start();
        setSize(200, 400);
        setTitle("TETRIS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel getStatusbar(){
        return statusbar;
    }
}
