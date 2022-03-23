package 设计模式.原型模式;

public class Main {
    public static void main(String[] args) {
        ShapeCache.initMap();
        Shape shape = ShapeCache.getShape("1");
        shape.draw();
        Shape shape1 = ShapeCache.getShape("2");
        shape1.draw();
    }
}
