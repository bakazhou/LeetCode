package 设计模式.工厂方法模式;

//抽象产品角色
public class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Audi!");
    }
}
