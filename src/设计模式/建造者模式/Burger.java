package ���ģʽ.������ģʽ;

public abstract class Burger implements Item{
    @Override
    public Packing packing() {
        //������ֽ�д��
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
