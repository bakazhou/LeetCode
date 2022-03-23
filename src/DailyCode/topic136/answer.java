package DailyCode.topic136;

import java.util.Arrays;

public class answer {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=-1;
        for (int i=0;i<nums.length;i=i+2){
            if (nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return ans;
    }
}
