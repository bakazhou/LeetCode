package ���ģʽ.ԭ��ģʽ;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;

public class ShapeCache {
    private static HashMap<String,Shape> map = new HashMap<>();
    public static Shape getShape(String shapeId) {
        Shape cachedShape = map.get(shapeId);
        //���ص��ǿ�¡����
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
