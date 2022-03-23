package 设计模式.简单工厂模式;

//抽象产品角色
public class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Audi!");
    }
}
