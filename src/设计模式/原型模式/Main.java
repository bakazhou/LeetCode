package ���ģʽ.ԭ��ģʽ;

public class Main {
    public static void main(String[] args) {
        ShapeCache.initMap();
        Shape shape = ShapeCache.getShape("1");
        shape.draw();
        Shape shape1 = ShapeCache.getShape("2");
        shape1.draw();
    }
}
