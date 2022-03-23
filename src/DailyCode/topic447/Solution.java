package DailyCode.topic447;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        //枚举
        int ans = 0,n=points.length;
        for (int i=0;i<n;i++){
            Map<Integer,Integer> map =new HashMap<>();
            for (int j=0;j<n;j++){
                //距离不开方，避免数据难以处理
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (!map.containsKey(dis)){
                    map.put(dis,1);
                }
                else {
                    map.put(dis,map.get(dis)+1);
                }
            }
            Set<Integer> set = map.keySet();
            for (Integer key:set){
                Integer dis = map.get(key);
                ans+=dis*(dis-1);
            }
        }
        return ans;
    }
}
