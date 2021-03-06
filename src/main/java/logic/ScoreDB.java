package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreDB {
    private ArrayList<Integer> scoreList;
    private static ScoreDB scoreDB;

    private ScoreDB(){
        scoreList = new ArrayList<>();
        File file = new File("score.txt");
        Scanner scan;
        try{
            scan = new Scanner(file);
            int i = 0;
            while(scan.hasNextLine()){
                scoreList.add(Integer.parseInt(scan.nextLine()));
                i++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static ScoreDB getInstance(){
        if(scoreDB == null){
            scoreDB = new ScoreDB();
        }
        return scoreDB;
    }

    public ArrayList<Integer> getAllScore(){
        return scoreList;
    }

    public void addScoreLine(int score){
        if(scoreList.size()-1 >= 10){
            scoreList.set(10, score);
        }else{
            scoreList.add(score);
        }
        sort();
    }

    private void sort(){
        Collections.sort(scoreList);
        Collections.reverse(scoreList);
    }

    public void writList(){
        try(FileWriter wr = new FileWriter("score.txt", false)){
            for(Integer array: scoreList){
                wr.write(Integer.toString(array));
                wr.write(System.lineSeparator());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
