package ���ģʽ.�򵥹���ģʽ;

//�������ɫ
public class Factor {
    public static Car driveCar(String name){
        if (name.equalsIgnoreCase("Benz")){
            return new Benz();
        }
        else if (name.equalsIgnoreCase("Audi")){
            return new Audi();
        }
        return null;
    }
}
