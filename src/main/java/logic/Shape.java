package logic;

import logic.Shapes.ShapesCreator.*;

import java.util.Random;

public class Shape {
    public Tetrominos pieceShape;
    public int[][] coords;

    public Shape(){
        coords = new int[4][2];
    }

    public void setShape(Tetrominos shape){
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
        int x = Math.abs(r.nextInt()) % 7;
        ShapesCreator shapes[] = {
                new CreateIShape(),
                new CreateJShape(),
                new CreateLShape(),
                new CreateOShape(),
                new CreateSShape(),
                new CreateTShape(),
                new CreateZShape()
        };
        shapes[x].createShapes().drawShape(shapes[x].getTetrominos(), this);
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

    // design pattern
    public Shape rotateLeft(){
        if(pieceShape == Tetrominos.O_SHAPE){
            return this;
        }
        Shape result = new Shape();
        result.pieceShape = pieceShape;
        for (int i = 0; i < 4 ; i++) {
            result.setX(i, getY(i));
            result.setY(i, -getX(i));
        }
        return result;
    }

    public Shape rotateRight(){
        if(pieceShape == Tetrominos.O_SHAPE){
            return this;
        }
        Shape result = new Shape();
        result.pieceShape = pieceShape;
        for (int i = 0; i < 4 ; i++) {
            result.setX(i, -getY(i));
            result.setY(i, getX(i));
        }
        return result;
    }

}
