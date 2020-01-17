package logic.Shapes.ShapesCreator;

import logic.Shapes.LShape;
import logic.Shapes.Shapes;
import logic.Tetrominos;

public class CreateLShape implements ShapesCreator{
    @Override
    public Shapes createShapes() {
        return new LShape();
    }

    @Override
    public Tetrominos getTetrominos() {
        return Tetrominos.L_SHAPE;
    }
}
