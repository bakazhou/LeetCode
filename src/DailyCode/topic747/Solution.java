package DailyCode.topic747;

import java.util.Arrays;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ20ÈÕ 13:39
 **/
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int max = Integer.MIN_VALUE,second = Integer.MIN_VALUE;
        int index = -1;
        for (int i=0;i<nums.length;i++){
            if (nums[i] > max){
                second = max;
                max = nums[i];
                index = i;
                continue;
            }
            if (nums[i] > second){
                second = nums[i];
            }
        }
        System.out.println(max);
        System.out.println(second);
        return max >= second*2 ? index : -1;
    }
}