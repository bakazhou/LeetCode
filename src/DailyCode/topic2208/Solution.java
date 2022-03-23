package DailyCode.topic2208;

import java.util.TreeMap;

/**
 * @author bakazhou
 * @description
 * @date 2022年03月22日 19:06
 **/
class Solution {
    public int halveArray(int[] nums) {
        TreeMap<Double,Integer> map = new TreeMap<>();
        int n = nums.length,step = 0;
        double sum = 0L;
        for (int i=0;i<n;i++){
            sum += nums[i];
            map.put((double) nums[i],map.getOrDefault((double) nums[i],0)+1);
        }
        double half = sum / 2;
        while (sum > half){
            final Double max = map.lastKey();
            //出现次数
            final Integer times = map.get(max);
            final double value = max / 2;
            sum -= value;
            step++;
            map.put(value,map.getOrDefault(value,0)+1);
            if (times == 1){
                map.remove(max);
            }else {
                map.put(max,times-1);
            }
        }
        return step;
    }
}
