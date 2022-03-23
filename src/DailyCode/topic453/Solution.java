package DailyCode.topic453;

import java.util.Arrays;

public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0],ans = 0;
        for(int i=1;i<nums.length;i++){
            ans += nums[i] - min;
        }
        return ans;
    }
}
