package 设计模式.建造者模式;

//肉食汉堡
public class MeatBurger extends Burger {
    @Override
    public String name() {
        return "MeatBurger";
    }

    @Override
    public float price() {
        return 10.0f;
    }
}
