package logic.Shapes.ShapesCreator;

import logic.Shapes.Shapes;
import logic.Shapes.ZShape;
import logic.Tetrominos;

public class CreateZShape implements ShapesCreator{
    @Override
    public Shapes createShapes() {
        return new ZShape();
    }

    @Override
    public Tetrominos getTetrominos() {
        return Tetrominos.Z_SHAPE;
    }
}
