package ���ģʽ.����ģʽ;

//����ʽ
/*
�Ƿ� Lazy ��ʼ������

�Ƿ���̰߳�ȫ����

ʵ���Ѷȣ���

���������ַ�ʽ�Ƚϳ��ã������ײ�����������
�ŵ㣺û�м�����ִ��Ч�ʻ���ߡ�
ȱ�㣺�����ʱ�ͳ�ʼ�����˷��ڴ档
������ classloader ���Ʊ����˶��̵߳�ͬ�����⣬������instance ����װ��ʱ��ʵ��������Ȼ������װ�ص�ԭ���кܶ��֣�
�ڵ���ģʽ�д�������ǵ��� getInstance ������ ����Ҳ����ȷ���������ķ�ʽ�����������ľ�̬������������װ�أ�
��ʱ���ʼ�� instance ��Ȼû�дﵽ lazy loading ��Ч����
 */
public class Single1 {
    private static Single1 single1 = new Single1();
    public static Single1 getInstance(){
        return single1;
    }
}
