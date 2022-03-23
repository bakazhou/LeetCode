package 设计模式.简单工厂模式;

//工厂类角色
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
