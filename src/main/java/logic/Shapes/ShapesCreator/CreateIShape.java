package logic.Shapes.ShapesCreator;

import logic.Shapes.IShape;
import logic.Shapes.Shapes;
import logic.Tetrominos;

public class CreateIShape implements ShapesCreator {
    @Override
    public Shapes createShapes() {
        return new IShape();
    }

    @Override
    public Tetrominos getTetrominos() {
        return Tetrominos.I_SHAPE;
    }
}
