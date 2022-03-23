package DailyCode.topic187;

import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int left = 0,right = 10, n = s.length();
        List<String> ans = new ArrayList<>();
        if (n==10){
            ans.add(s);
            return ans;
        }
        Map<String,Integer> map= new HashMap<>();
        while (right<n){
            String tem = s.substring(left,right);
            System.out.println(tem);
            if (!map.containsKey(tem)){
                map.put(tem,1);
            }else {
                map.put(tem,map.get(tem)+1);
            }
            right++;
            left++;
        }
        Set<String> set = map.keySet();
        for (String key:set){
            if (map.get(key)>=2){
                ans.add(key);
            }
        }
        return ans;
    }
}
