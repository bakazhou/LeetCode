package 设计模式.抽象工厂模式;

import org.omg.CORBA.PUBLIC_MEMBER;

public abstract class Factor {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
