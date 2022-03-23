package DailyCode.topic888;

import java.util.Arrays;

public class answer {
    /*
    ����Ŀ�������˵��ǹ���������ͬ
    ������Ҫ�ҳ������ǹ���������/2 sum_A-sum_B
    ��������������������==sum_A-sum_B���ǹ�
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        /*
        ����ѭ��ֱ���ҵ��ǹ�Ϊֹ
         */
        int[] ans = new int[2];
        int sum_A=0,sum_B=0;
        for(int i=0;i<A.length;i++){
            sum_A+=A[i];
        }
        for(int i=0;i<B.length;i++){
            sum_B+=B[i];
        }
        if (sum_A>sum_B){
            for(int i=0;i<A.length;i++){
                for(int j=0;j<B.length;j++){
                    if (A[i]-B[j]==(sum_A-sum_B)/2){
                        ans[0]=A[i];
                        ans[1]=B[j];
                        return ans;
                    }
                }
            }
        }
        else if (sum_A<sum_B){
            for(int i=0;i<A.length;i++){
                for(int j=0;j<B.length;j++){
                    if (B[j]-A[i]==(sum_B-sum_A)/2){
                        ans[0]=A[i];
                        ans[1]=B[j];
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
    public int[] fairCandySwap1(int[] A, int[] B) {
        /*
        ͨ��while���ٱ�������
         */
        int[] ans = new int[2];
        int sum_A=0,sum_B=0;
        for(int i=0;i<A.length;i++){
            sum_A+=A[i];
        }
        for(int i=0;i<B.length;i++){
            sum_B+=B[i];
        }
        int dif=(sum_A-sum_B)/2;
        int aleng=0,bleng=0;
        /*
        ����
         */
        Arrays.sort(A);
        Arrays.sort(B);
        while (aleng<A.length && bleng<B.length){
            if (A[aleng]-B[bleng]==dif){
                ans[0]=A[aleng];
                ans[1]=B[bleng];
                return ans;
            }
            if (A[aleng]-B[bleng]>dif){//B�ǹ�����̫С
                bleng++;
            }
            else if (A[aleng]-B[bleng]<dif){//A�ǹ�����̫С
                aleng++;
            }
        }
        return ans;
    }
}
