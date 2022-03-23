package DailyCode.topic2050;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月10日 22:26
 **/
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] clone = time.clone();
        int curTime = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] entry = new int[n+1];
        for (int i=0;i<relations.length;i++){
            entry[relations[i][1]]++;
            if (!map.containsKey(relations[i][0])){
                ArrayList<Integer> road = new ArrayList<>();
                road.add(relations[i][1]);
                map.put(relations[i][0],road);
            }else {
                map.get(relations[i][0]).add(relations[i][1]);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=1;i<entry.length;i++){
            //入度为0可以作为起点
            if (entry[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int first = queue.getFirst();
                curTime = Math.max(curTime,clone[first-1]);
                queue.removeFirst();
                if (map.containsKey(first)){
                    ArrayList<Integer> road = map.get(first);
                    for (int j=0;j<road.size();j++){
                        int next = road.get(j);
                        entry[next]--;
                        if (entry[next] == 0){
                            clone[next-1] = Math.max(time[next-1]+clone[first-1],clone[next-1]);
                            queue.add(next);
                        }else {
                            clone[next-1] = Math.max(time[next-1]+clone[first-1],clone[next-1]);
                        }
                    }
                }
            }
        }

        return curTime;
    }
}
