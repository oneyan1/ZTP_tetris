package logic.Shapes.ShapesCreator;

import logic.Shapes.Shapes;
import logic.Shapes.TShape;
import logic.Tetrominos;

public class CreateTShape implements ShapesCreator{
    @Override
    public Shapes createShapes() {
        return new TShape();
    }

    @Override
    public Tetrominos getTetrominos() {
        return Tetrominos.T_SHAPE;
    }
}
