package java.factory.method;


import java.factory.Circle;
import java.factory.Shape;

public class CircleFactory implements ShapeFactory {

    @Override
    public Shape getShape() {
        return new Circle();
    }

}
