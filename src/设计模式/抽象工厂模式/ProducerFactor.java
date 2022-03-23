package ���ģʽ.���󹤳�ģʽ;

public class ProducerFactor {
    public static Factor getFactor(String type){
        if (type.equalsIgnoreCase("color")){
            return new ColorFactor();
        }
        else if (type.equalsIgnoreCase("shape")){
            return new ShapeFactor();
        }
        return null;
    }
}
