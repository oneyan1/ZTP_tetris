package logic;

import java.util.Random;

public class Shape {
    private Tetrominos pieceShape;
    private int[][] coords;

    public Shape(){
        coords = new int[4][2];
        setShape(Tetrominos.NO_SHAPE);
    }

    public void setShape(Tetrominos shape){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2 ; j++) {
                coords[i][j] = shape.coords[i][j];
            }
        }
        pieceShape = shape;
    }

    public void setX(int index, int x){
        coords[index][0] = x;
    }

    public void setY(int index, int y){
        coords[index][1] = y;
    }

    public int getX(int index){
        return coords[index][0];
    }

    public int getY(int index){
        return coords[index][1];
    }

    public Tetrominos getShape(){
        return pieceShape;
    }

    public void setRandomShape(){
        Random r = new Random();
        int x = Math.abs(r.nextInt())%7 + 1;
        Tetrominos[] values = Tetrominos.values();
        setShape(values[x]);
    }

    public int minX(){
        int min = coords[0][0];
        for (int i = 0; i < 4 ; i++) {
            min = Math.min(min, coords[i][0]);
        }
        return min;
    }

    public int minY(){
        int min = coords[0][1];
        for (int i = 0; i < 4 ; i++) {
            min = Math.min(min, coords[i][1]);
        }
        return min;
    }


}
