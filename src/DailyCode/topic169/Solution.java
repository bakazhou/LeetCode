package DailyCode.topic169;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                int n = map.get(nums[i])+1;
                map.put(nums[i],n);
            }
            if (map.get(nums[i]) > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }
}