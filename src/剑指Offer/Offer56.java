package 剑指Offer;

import java.util.HashMap;
import java.util.Set;

public class Offer56 {

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> calculate = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (calculate.containsKey(nums[i])){
                calculate.put(nums[i],1);
            }else {
                calculate.put(nums[i],calculate.get(nums[i])+1);
            }
        }
        Set<Integer> set = calculate.keySet();
        for (Integer key : set){
            if (calculate.get(key)==1){
                return key;
            }
        }
        return 0;
    }
}
