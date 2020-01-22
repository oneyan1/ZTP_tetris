package windows;

import logic.ScoreDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 *  Klasa implementacja menu glownego gry, pozwalia razpącząć nową gre, zobaczyć listą wynoków, zakonczyć gre
 */
public class Menu extends JFrame{

    /**
     *  Przycisk Nowa gra
     */
    private JButton newGameBtn;
    /**
     *  Przycisk Listsa wyników
     */
    private JButton scoreListBtn;
    /**
     * Przycisk Zakonczyć gre
     */
    private JButton exitGameBtn;
    /**
     * Dostęmp do listy danych z wynikami
     */
    private ScoreDB scoreDB;

    /**
     * Konstuktor inicjalizuje główne okne programu,
     * ustawia rozmiar okna,
     * dodaje przyciski i definuje aktywności do nich
     */
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

    /**
     * Metoda tworząnca nowe pzyciski
     *
     * @param panel panel do ktorego nowy przycisk będzie dodany
     * @param btnName nazwa przysicku
     * @param y wspołżędna po Y na której muszi byc umiesczony przycisk
     * @return obiekt prycisku niezbędny do dodania actywnosci
     */
    private JButton newBtn(JPanel panel, String btnName, int y){
        panel.setLayout(null);
        JButton newBtn = new JButton(btnName);
        newBtn.setBounds(65, y ,150,40);
        panel.add(newBtn);
        return newBtn;
    }

    /**
     * Metoda uruchamia się po wciśniencu przycoska New Game
     * tworzy klas okna pola gry
     * @param panel panel na którym był umieszczony przycosk, będzie ten panel zamknęty w trakcie działania
     */
    private void newGame(JFrame panel){
        panel.dispose();
        GameFrame gameFrame = new GameFrame();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    /**
     *  Metoda tworzy nowe okno,
     *  odbira z klasy ScoreDB dostęmp do listy wyników,
     *  dodaje całą liste wyników do nowo utworząnej paneli
     *  dodaje nowy panel do okna
     */
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

    /**
     * Metoda realizuje aktywność przycisku Exit
     */
    private void exitGame(){
        System.exit(1);
    }

}
