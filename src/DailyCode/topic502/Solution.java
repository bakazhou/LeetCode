package DailyCode.topic502;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //k个项目 w资本 profits利润 capital所需资本
        int ans = w,n = profits.length,cur_k = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        //map含义为存储 当前资本可以获得的利润选择
        for (int i=0;i<n;i++){
            if (!map.containsKey(capital[i])){
                ArrayList<Integer> list = new ArrayList();
                list.add(profits[i]);
                map.put(capital[i],list);
            }else {
                map.get(capital[i]).add(profits[i]);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer key : set){
            Collections.sort(map.get(key), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1>=o2?-1:1;
                }
            });
        }
        System.out.println(map);
        while (cur_k!=k){
            int cur_w = ans,max = Integer.MIN_VALUE,delete_w = Integer.MIN_VALUE;
            for (int i=cur_w;i>=0;i--){
                if (map.containsKey(i)){
                    ArrayList<Integer> list = map.get(i);
                    if (list.get(0)>max){
                        delete_w = i;//需要删除的利润
                        max = list.get(0);
                    }
                }
            }
            if (max == Integer.MIN_VALUE){
                return ans;
            }else {
                map.get(delete_w).remove(0);
                if (map.get(delete_w).isEmpty()){
                    map.remove(delete_w);
                }
                ans+=max;
            }
            cur_k++;
        }
        return ans;
    }
}