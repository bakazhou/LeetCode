package ���ģʽ.���󹤳�ģʽ;

public class Main {
    public static void main(String[] args) {
        Factor color = ProducerFactor.getFactor("color");
        Color red = color.getColor("red");
        red.fill();

        Factor shape = ProducerFactor.getFactor("shape");
        Shape square = shape.getShape("square");
        square.draw();
    }
}
