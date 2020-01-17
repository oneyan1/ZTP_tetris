package logic.Shapes.ShapesCreator;

import logic.Shapes.SShape;
import logic.Shapes.Shapes;
import logic.Tetrominos;

public class CreateSShape implements ShapesCreator{
    @Override
    public Shapes createShapes() {
        return new SShape();
    }

    @Override
    public Tetrominos getTetrominos() {
        return Tetrominos.S_SHAPE;
    }
}
