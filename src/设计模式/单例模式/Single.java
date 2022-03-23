package ���ģʽ.����ģʽ;

//����ģʽ ��Ҫʱ�Ž��г�ʼ�� ����Ҫʱ��Ϊnull
public class Single {
    private static Single single = null;
    //�̲߳���ȫ
//    public static Single getInstance(){
//        if (single == null){
//            single = new Single();
//        }
//        return single;
//    }
    //�̰߳�ȫ
    /*
    2������ʽ���̰߳�ȫ
    �Ƿ� Lazy ��ʼ������
    �Ƿ���̰߳�ȫ����
    ʵ���Ѷȣ���
    ���������ַ�ʽ�߱��ܺõ� lazy loading���ܹ��ڶ��߳��кܺõĹ��������ǣ�Ч�ʺܵͣ�99% ����²���Ҫͬ����
    �ŵ㣺��һ�ε��òų�ʼ���������ڴ��˷ѡ�
    ȱ�㣺������� synchronized ���ܱ�֤��������������Ӱ��Ч�ʡ�
    getInstance() �����ܶ�Ӧ�ó����Ǻܹؼ����÷���ʹ�ò�̫Ƶ������
     */
    public static synchronized Single getInstance(){
        if (single == null){
            single = new Single();
        }
        return single;
    }
}
