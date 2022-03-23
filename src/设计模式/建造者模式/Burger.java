package 设计模式.建造者模式;

public abstract class Burger implements Item{
    @Override
    public Packing packing() {
        //汉堡用纸盒打包
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
