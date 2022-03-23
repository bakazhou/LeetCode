package 设计模式.工厂方法模式;

public class Main {
    public static void main(String[] args) {
        Factor factor = new BenzFactor();
        Car car = factor.driveCar();
        car.drive();
    }
}
