import javax.swing.*;

public class Menu {
    public Menu(){
        JFrame frame = new JFrame("Menu");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        newBtn(panel, "New Game", 30);
        newBtn(panel, "Score records", 100);
        newBtn(panel, "Exit", 170);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void newBtn(JPanel panel, String btnName, int y){
        panel.setLayout(null);
        JButton newBtn = new JButton(btnName);
        newBtn.setBounds(65, y ,150,40);
        panel.add(newBtn);
    }
}
