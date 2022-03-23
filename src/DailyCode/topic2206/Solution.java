package DailyCode.topic2206;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê03ÔÂ22ÈÕ 18:51
 **/
class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Integer key : map.keySet()){
            if (map.get(key) % 2 != 0){
                return false;
            }
        }
        return true;
    }
}