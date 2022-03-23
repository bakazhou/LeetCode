package DailyCode.topic1588;

import java.util.Arrays;

public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length,ans = 0;
        int[] pre = new int[n+1];
        for (int i=1;i<=n;i++){
            pre[i]=pre[i-1]+arr[i-1];
        }
        //�ҵ���ǰ���鳤�ȵ��������
        int dis = n;
        if (n%2!=0){
            dis = n-1;
        }
        for (int leng=1;leng<=n;leng=leng+2){//��ͬ�������ȵ�����
            for (int left=0;left+leng-1<n;left++){//��˵�
                int right = left-1+leng;
                ans+=pre[right+1]-pre[left];
            }
        }
        return  ans;
    }
}
