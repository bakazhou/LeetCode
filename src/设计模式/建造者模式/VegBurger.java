package 设计模式.建造者模式;

//蔬菜汉堡
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 7.5f;
    }
}
