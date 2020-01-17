package logic.Shapes.ShapesCreator;

import logic.Shapes.Shapes;
import logic.Tetrominos;

public interface ShapesCreator {
    Shapes createShapes();
    Tetrominos getTetrominos();
}
