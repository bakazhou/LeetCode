package ���ģʽ.������ģʽ;

public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        //������ƿ��װ
        return new Bottle();
    }
    @Override
    public abstract float price();
}
