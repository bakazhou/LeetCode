package DailyCode.topic1913;

import java.util.Arrays;

public class answer {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1]*nums[nums.length-2]-nums[0]*nums[1];
    }
}
