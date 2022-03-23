package 设计模式.建造者模式;
//可口可乐
public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
