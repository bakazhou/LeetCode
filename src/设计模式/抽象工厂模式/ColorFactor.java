package ���ģʽ.���󹤳�ģʽ;

public class ColorFactor extends Factor{
    @Override
    public Color getColor(String color) {
        if (color.equalsIgnoreCase("red")){
            return new Red();
        }else if (color.equalsIgnoreCase("blue")){
            return new Blue();
        }else if (color.equalsIgnoreCase("black")){
            return new Black();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
