package ½£Ö¸Offer2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Offer004 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer key : set){
            if (map.get(key)==1){
                return key;
            }
        }
        return -1;
    }
}
