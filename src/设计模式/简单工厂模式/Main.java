package 设计模式.简单工厂模式;

//暴发户下令开车
public class Main {
    public static void main(String[] args) {
        Car car = Factor.driveCar("Benz");
        car.drive();
    }
}
