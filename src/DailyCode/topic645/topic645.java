package DailyCode.topic645;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class topic645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if ((set.contains(nums[i]))){
                ans[0]=nums[i];
                break;
            }else {
                set.add(nums[i]);
            }
        }
        for(int i=1;i<=nums[nums.length-1]+1;i++){
            if (!set.contains(i)){
                ans[1]=i;
            }
        }
        return ans;
    }
}
