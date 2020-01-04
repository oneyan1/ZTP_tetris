import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        //function create new buttons
        panel.setLayout(null);
        JButton newGameBtn = new JButton("New game");
        newGameBtn.setBounds(65,30,150,40);
        panel.add(newGameBtn);

        JButton scoreListBtn = new JButton("Score records");
        scoreListBtn.setBounds(65, 100, 150, 40);
        panel.add(scoreListBtn);

        JButton exitGameBtn = new JButton("Exit game");
        exitGameBtn.setBounds(65, 170, 150, 40);
        panel.add(exitGameBtn);

        //actins
        newGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //new game field and another shit
            }
        });

        scoreListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //score frame
            }
        });

        exitGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(1);
            }
        });
        // end actions

        //end function
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
