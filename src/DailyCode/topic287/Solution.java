package DailyCode.topic287;

import java.util.Arrays;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ07ÈÕ 13:27
 **/
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}