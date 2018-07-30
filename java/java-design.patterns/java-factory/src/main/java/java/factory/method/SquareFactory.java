package java.factory.method;

import java.factory.Shape;
import java.factory.Square;

public class SquareFactory implements ShapeFactory {

    @Override
    public Shape getShape() {
        return new Square();
    }

}
