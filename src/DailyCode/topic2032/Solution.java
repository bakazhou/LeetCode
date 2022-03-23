package DailyCode.topic2032;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ17ÈÕ 10:04
 **/
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0;i<nums1.length;i++){
            if (!map.containsKey(nums1[i])){
                Set<Integer> set = new HashSet<>();
                set.add(1);
                map.put(nums1[i],set);
            }else {
                map.get(nums1[i]).add(1);
            }
        }
        for (int i=0;i<nums2.length;i++){
            if (!map.containsKey(nums2[i])){
                Set<Integer> set = new HashSet<>();
                set.add(2);
                map.put(nums2[i],set);
            }else {
                map.get(nums2[i]).add(1);
            }
        }
        for (int i=0;i<nums3.length;i++){
            if (!map.containsKey(nums3[i])){
                Set<Integer> set = new HashSet<>();
                set.add(3);
                map.put(nums3[i],set);
            }else {
                map.get(nums3[i]).add(3);
            }
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (int key:set){
            if (map.get(key).size()>=2){
                res.add(key);
            }
        }
        return res;
    }
}