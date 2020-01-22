package logic;

import logic.Shapes.ShapesCreator.*;

import java.util.Random;

public class Shape {
    public Tetrominos pieceShape;
    public int[][] coords;
    public ShapesCreator shapes[] = {
            new CreateIShape(),
            new CreateJShape(),
            new CreateLShape(),
            new CreateOShape(),
            new CreateSShape(),
            new CreateTShape(),
            new CreateZShape()
    };

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

        shapes[x].createShapes().drawShape(shapes[x].getTetrominos(), this);
    }
}
