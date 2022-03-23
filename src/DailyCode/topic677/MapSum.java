package DailyCode.topic677;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MapSum {
    Map<String,Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int ans = 0;
        Set<String> set = map.keySet();
        for (String key : set){
            if (key.startsWith(prefix)){
                ans += map.get(key);
            }
        }
        return ans;
    }
}