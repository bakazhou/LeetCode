package 设计模式.建造者模式;

public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        //冷饮用瓶子装
        return new Bottle();
    }
    @Override
    public abstract float price();
}
