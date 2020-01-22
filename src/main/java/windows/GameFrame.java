package windows;

import logic.Board;

import javax.swing.*;
import java.awt.*;

/**
 *  Klasa tworząca okna w którym będzie umieszczone pole gry
 *  dodaje nowe utworząne pole gry do okna i razpoczyna razgrywkę
 */
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

    /**
     * Geter dla dostęmpu do pola wypisania statusa gry
     * @return pole status
     */
    public JLabel getStatusbar(){
        return statusbar;
    }
}
