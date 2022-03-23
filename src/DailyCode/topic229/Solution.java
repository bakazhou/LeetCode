package DailyCode.topic229;

import java.util.*;

public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length==0){
            return ans;
        }
        int k = nums.length/3;
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i])){
                continue;
            }
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
            int n = map.get(nums[i]);
            if (n>k){
                ans.add(nums[i]);
                set.add(nums[i]);
            }
        }
        return ans;
    }
}
