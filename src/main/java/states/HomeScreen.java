package states;

import windows.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen implements GameState {

    JFrame frame;

    private JButton newGameBtn;
    private JButton scoreListBtn;
    private JButton exitGameBtn;

    public HomeScreen() {
        frame = new JFrame("windows.Menu");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        newGameBtn = newBtn(panel, "New Game", 30);
        scoreListBtn = newBtn(panel, "Score records", 100);
        exitGameBtn = newBtn(panel, "Exit", 170);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        newGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newGame(frame);
            }
        });
        scoreListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                scoreList();
            }
        });
        exitGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exitGame();
            }
        });
    }

    @Override
    public void draw() { }

    @Override
    public void update() { }

    private JButton newBtn(JPanel panel, String btnName, int y){
        panel.setLayout(null);
        JButton newBtn = new JButton(btnName);
        newBtn.setBounds(65, y ,150,40);
        panel.add(newBtn);
        return newBtn;
    }

    private void newGame(JFrame panel){
        panel.dispose();
        GameFrame gameFrame = new GameFrame();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    private void scoreList(){

    }

    private void exitGame(){
        System.exit(1);
    }
}
