package 设计模式.工厂方法模式;

public class AudiFactor implements Factor {
    @Override
    public Car driveCar() {
        return new Audi();
    }
}
