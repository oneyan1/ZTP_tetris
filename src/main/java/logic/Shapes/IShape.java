package logic.Shapes;

import logic.Shape;
import logic.Tetrominos;

public class IShape implements Shapes {
    @Override
    public void drawShape(Tetrominos shape, Shape piece) {
        int coords[][] = {{0,-1},{0,0},{0,1},{0,2}};

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2 ; j++) {
                piece.coords[i][j] = coords[i][j];
            }
        }
        piece.pieceShape = shape;
    }
}
