package DailyCode.topic2044;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��16�� 12:27
 **/
class Solution {
    int count = 0,max = 0;
    public int countMaxOrSubsets(int[] nums) {
        for (int i : nums) {
            max |= i;
            System.out.println(max);
        }
        dfs(nums,0,0);
        return count;
    }
    public void dfs(int[] nums,int index,int cur){
        if (index == nums.length){
            if(cur == max){
                count++;
            }
            return;
        }
        //ѡ�������
        dfs(nums, index+1, cur|nums[index]);
        //��ѡ�������
        dfs(nums,index+1,cur);
    }
}
