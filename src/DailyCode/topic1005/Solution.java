package DailyCode.topic1005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��04�� 15:14
 **/
public class Solution {

    //����˼·:�и���ʱ����������С�ĸ���,û����ʱ����������С����������0
    public int largestSumAfterKNegations(int[] nums, int k) {
        int op = 0,sum = 0;
        Arrays.sort(nums);
        List<Integer> index = new ArrayList<>();
        boolean flag = false;//�ж���û��0
        for (int i=0;i<nums.length;i++){
            if (nums[i]<0){
                index.add(i);
            }
            else if (nums[i]==0){
                flag = true;
            }
            sum += nums[i];
        }
        while (op!=k){
            if (!index.isEmpty()){
                for (int i=0;i<index.size() && i<k;i++){
                    nums[index.get(i)] = Math.abs(nums[index.get(i)]);
                    sum += nums[index.get(i)]*2;
                    op++;
                }
                index.clear();
                if (op == k){
                    return sum;
                }
            }
            Arrays.sort(nums);
            //ʣ���������
            int numOpe = k-op;
            if (numOpe%2!=0 && !flag){
                //����С�����ֲ���1��
                sum -= nums[0]*2;
                return sum;
            }
        }
        return sum;
    }
}
