package DailyCode.topic554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class anwer {
    public int leastBricks(List<List<Integer>> wall) {
        int ans = 0;
        int n = wall.size();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            int sum = 0;
            List<Integer> list = wall.get(i);
            for (int j=0;j<list.size();j++){
                int dis = list.get(j);
                sum+=dis;
                if (map.containsKey(sum)) map.put(sum,map.get(sum)+1);
                else map.put(sum,1);
            }
            //不能从最后的缝隙向下
            map.remove(sum);
        }
        Set<Integer> set = map.keySet();
        for (Integer skey:set){
            if (map.get(skey)>ans) ans=map.get(skey);
        }
        return n-ans;
    }
}
