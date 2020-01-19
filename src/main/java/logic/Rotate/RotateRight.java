package logic.Rotate;

import logic.Shape;

public class RotateRight extends Rotate {
    @Override
    public void calculateRotate(Shape newShape, Shape oldShape) {
        for (int i = 0; i < 4 ; i++) {
            newShape.setX(i, -oldShape.getY(i));
            newShape.setY(i, oldShape.getX(i));
        }
    }
}
