package DailyCode.topic128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ07ÈÕ 13:15
 **/
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for (int i=0;i<nums.length;i++){
            int cur = nums[i];
            if (set.contains(cur)){
                int size = 1;
                int curNum = cur;
                while (true){
                    curNum++;
                    if (!set.contains(curNum)){
                        break;
                    }
                    size++;
                    set.remove(curNum);
                }
                set.remove(cur);
                ans = Math.max(ans,size);
            }
        }
        return ans;
    }
}