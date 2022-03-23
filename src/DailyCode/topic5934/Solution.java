package DailyCode.topic5934;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ12ÈÕ 12:29
 **/
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0,j=clone.length-1;i<k;i++,j--){
            if (!map.containsKey(clone[j])){
                map.put(clone[j],1);
            }else {
                map.put(clone[j],map.get(clone[j])+1);
            }
        }
        for (int i=0,j = 0;i<nums.length && j<k;i++){
            if (map.isEmpty()){
                break;
            }
            if (map.containsKey(nums[i])){
                ans[j++] = nums[i];
                if (map.get(nums[i]) == 1){
                    map.remove(nums[i]);
                }else {
                    map.put(nums[i],map.get(nums[i])-1);
                }
            }
        }
        return ans;
    }
}