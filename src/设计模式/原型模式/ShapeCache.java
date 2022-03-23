package 设计模式.原型模式;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;

public class ShapeCache {
    private static HashMap<String,Shape> map = new HashMap<>();
    public static Shape getShape(String shapeId) {
        Shape cachedShape = map.get(shapeId);
        //返回的是克隆对象
        return (Shape) cachedShape.clone();
    }
    public static void initMap(){
        Circle circle = new Circle();
        circle.setId("1");
        map.put("1",circle);
        Square square = new Square();
        square.setId("2");
        map.put("2",square);
    }
}
