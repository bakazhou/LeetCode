package DailyCode.topic2080;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ09ÈÕ 19:14
 **/
class RangeFreqQuery {
    int[] nums;
    Map<String,Integer> map;
    Set<Integer> set;
    public RangeFreqQuery(int[] arr) {
        nums = arr;
        set = new HashSet<>();
        map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
    }
    public int query(int left, int right, int value) {
        if (!set.contains(value)){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(left+"+"+right+"+"+value);
        String str = sb.toString();
        if (map.containsKey(str)){
            return map.get(str);
        }
        int n = 0;
        for(int i=left;i<=right;i++){
            if (nums[i] == value){
                n++;
            }
        }
        map.put(sb.toString(),n);
        return n;
    }
}