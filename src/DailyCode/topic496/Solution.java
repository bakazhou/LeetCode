package DailyCode.topic496;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i=0;i<nums2.length;i++){
            if (stack.isEmpty()){
                stack.add(nums2[i]);
            }else {
                while (!stack.isEmpty() && stack.getLast()<nums2[i]){
                    int num = stack.getLast();
                    stack.removeLast();
                    map.put(num,nums2[i]);
                }
                stack.add(nums2[i]);
            }
        }
        while (!stack.isEmpty()){
            int num = stack.getLast();
            stack.removeLast();
            map.put(num,-1);
        }
        for (int i=0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}