package DailyCode.topic414;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i=n-1;i>=0;i--){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
                if (set.size()==3){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
