package ���ģʽ.����ģʽ;

//˫����/˫��У������DCL���� double-checked locking��
/*
JDK �汾��JDK1.5 ��
�Ƿ� Lazy ��ʼ������
�Ƿ���̰߳�ȫ����
ʵ���Ѷȣ��ϸ���
���������ַ�ʽ����˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ����ܡ�
getInstance() �����ܶ�Ӧ�ó���ܹؼ���
 */
public class Single2 {
    private volatile static Single2 single2 = null;
    public static Single2 getInstance(){
        //��������
        synchronized (Single2.class){
            if (single2==null){
                single2 = new Single2();
            }
        }
        return single2;
    }
}
