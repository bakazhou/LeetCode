package 设计模式.单例模式;

//双检锁/双重校验锁（DCL，即 double-checked locking）
/*
JDK 版本：JDK1.5 起
是否 Lazy 初始化：是
是否多线程安全：是
实现难度：较复杂
描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
getInstance() 的性能对应用程序很关键。
 */
public class Single2 {
    private volatile static Single2 single2 = null;
    public static Single2 getInstance(){
        //对类上锁
        synchronized (Single2.class){
            if (single2==null){
                single2 = new Single2();
            }
        }
        return single2;
    }
}
