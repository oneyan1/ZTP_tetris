package logic.Shapes.ShapesCreator;

import logic.Shapes.JShape;
import logic.Shapes.Shapes;
import logic.Tetrominos;

public class CreateJShape implements ShapesCreator {
    @Override
    public Shapes createShapes() {
        return new JShape();
    }

    @Override
    public Tetrominos getTetrominos() {
        return Tetrominos.J_SHAPE;
    }
}
