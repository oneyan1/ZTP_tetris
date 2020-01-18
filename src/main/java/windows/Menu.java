package windows;


import logic.ScoreDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{

    private JButton newGameBtn;
    private JButton scoreListBtn;
    private JButton exitGameBtn;
    private ScoreDB scoreDB;

    public Menu(){
        JFrame frame = new JFrame("Menu");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        scoreDB = ScoreDB.getInstance();
        newGameBtn = newBtn(panel, "New Game", 30);
        scoreListBtn = newBtn(panel, "Score", 100);
        exitGameBtn = newBtn(panel, "Exit", 170);
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

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
        JFrame score = new JFrame("Score");
        score.setSize(300, 100);
        JPanel scoreField = new JPanel();
        for(int i = 0; i < scoreDB.getAllScore().size(); i++){
            JLabel scorePoint = new JLabel();
            scorePoint.setText(scoreDB.getAllScore().get(i).toString());
            scoreField.add(scorePoint, BorderLayout.CENTER);
        }
        score.add(scoreField);
        score.setLocationRelativeTo(null);
        score.setVisible(true);
    }

    private void exitGame(){
        System.exit(1);
    }

}
