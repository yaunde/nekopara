package java.factory.method;

public class FactoryMethodDemo {
	
	public static void main(String[] args) {
		ShapeFactory circleFactory = new CircleFactory();
		circleFactory.getShape().draw();
		ShapeFactory rectangleFactory = new RectangleFactory();
		rectangleFactory.getShape().draw();
		ShapeFactory squareFactory = new SquareFactory();
		squareFactory.getShape().draw();
	}
 
}
