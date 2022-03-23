package DailyCode.topic1436;

import java.util.*;

public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (List<String> strings : paths){
            map.put(strings.get(0),strings.get(1));
            set.add(strings.get(0));
            set.add(strings.get(1));
        }
        for (String key:set){
            if (!map.containsKey(key)){
                return key;
            }
        }
        return "";
    }
}
