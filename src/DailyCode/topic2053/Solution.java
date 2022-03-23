package DailyCode.topic2053;

import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> set = new HashSet<>();
        Set<String> cal = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (!set.contains(arr[i])){
                set.add(arr[i]);
                cal.add(arr[i]);
            }else {
                cal.remove(arr[i]);
            }
        }
        for (int i=0;i<arr.length;i++){
            if (cal.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        return list.size()<k?"":list.get(k-1);
    }
}