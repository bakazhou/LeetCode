package ����DPģ��;

/*
�����������ͨ��
����DP����·��α����
����:��ҽ���III
�ѵ����ھ��ߵ�ѡ��ͷ���
 */

public class Solution {
    public static class Info{
        public int doValue;//�����Ի�õļ�ֵ
        public int noValue;//�������Ի������ֵ
        public Info(int n,int m){
            this.doValue=n;
            this.noValue=m;
        }
    }
//    public Info judge(E e){//���о���
//        if (e == null){
//            return new Info(e.value,0);
//        }
//        int doValue = e.value;
//        int noValue = 0;
//        while(e.next == null){//e��������,��ô��Ҫ�������еĺ�̽��о���
//            Info info = judge(e.next);
//            doValue += info.noValue;
//            noValue += Math.max(info.doValue,info.noValue);
//        }
//        return new Info(doValue,noValue);
//    }

}
