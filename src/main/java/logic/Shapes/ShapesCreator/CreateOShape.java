package logic.Shapes.ShapesCreator;

import logic.Shapes.OShape;
import logic.Shapes.Shapes;
import logic.Tetrominos;

public class CreateOShape implements ShapesCreator {
    @Override
    public Shapes createShapes() {
        return new OShape();
    }

    @Override
    public Tetrominos getTetrominos() {
        return Tetrominos.O_SHAPE;
    }
}
