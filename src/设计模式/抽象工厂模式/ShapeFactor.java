package 设计模式.抽象工厂模式;

public class ShapeFactor extends Factor {
    @Override
    public Color getColor(String color) {

        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape.equalsIgnoreCase("circles")){
            return new Circles();
        }else if (shape.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }else if (shape.equalsIgnoreCase("square")){
            return new Square();
        }
        return null;
    }
}
