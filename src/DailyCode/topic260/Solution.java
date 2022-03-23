package DailyCode.topic260;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                set.remove(nums[i]);
            }
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for (int num : set){
            ans[index] = num;
            index++;
        }
        return ans;
    }
}