package 设计模式.抽象工厂模式;

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
