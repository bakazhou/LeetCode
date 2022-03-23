package DailyCode.topic881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
        �����������飺{a1, a2, a3, a4}������a4 + a1 <= limit, a4 + a2 <= limit��
        ��ʱ��a4�������Ӧ���Ǵ���a2��������a1����������С��ʹ�ø����׸�a3һ���ߡ���ʵ���ϣ���Ȼa1,a2���ܸ�a4һ���ߣ�
        ��a4�ִ���a3����ôa3�ض�Ҳ�ܸ�a1��a2һ���ߵġ��������뿼�������Σ�ֱ�ӿ������ص��ܷ�������һ���߼��ɡ�
         */
        Arrays.sort(people);
        int ans = 0;//����ͧ����
        int nums = people.length;
        int left = 0,right = nums-1;
        while (nums!=0){
           int capacity = limit;
           capacity = capacity - people[right];
           right--;
           nums--;
           if (people[left]<=capacity){
               left++;
               nums--;
           }
           ans++;
        }
        return ans;
    }
}
