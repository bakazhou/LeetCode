package 设计模式.工厂方法模式;

//具体产品角色
public class Benz implements Car {

    @Override
    public void drive() {
        System.out.println("Drive Benz!");
    }
}
