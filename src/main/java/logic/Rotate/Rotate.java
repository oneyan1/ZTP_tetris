package logic.Rotate;

import logic.Shape;
import logic.Tetrominos;

public abstract class Rotate {
    private Shape shape;

    public Shape rotate(Shape oldShape){
        if(oldShape.pieceShape == Tetrominos.O_SHAPE){
            return oldShape;
        }
        shape = new Shape();
        shape.pieceShape = oldShape.pieceShape;
        calculateRotate(shape, oldShape);
        return shape;
    }

    public abstract void calculateRotate(Shape newShape, Shape oldShape);
}
