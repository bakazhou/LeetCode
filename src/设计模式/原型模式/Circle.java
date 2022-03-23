package 设计模式.原型模式;

public class Circle extends Shape{
    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    void draw() {
        System.out.println("draw a Circle");
    }
}
