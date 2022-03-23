package 设计模式.原型模式;

public class Square extends Shape {
    @Override
    public String getType() {
        return "Square";
    }

    @Override
    void draw() {
        System.out.println("draw a Square");
    }
}
