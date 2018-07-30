package java.factory.method;


import java.factory.Rectangle;
import java.factory.Shape;

public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape getShape() {
        return new Rectangle();
    }

}
