package 设计模式.建造者模式;

//百事可乐
public class Pesi extends ColdDrink {
    @Override
    public String name() {
        return "Pesi";
    }

    @Override
    public float price() {
        return 2.0f;
    }
}
