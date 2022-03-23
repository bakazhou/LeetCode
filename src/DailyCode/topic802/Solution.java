package DailyCode.topic802;

import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        /*
        拓扑排序是找到图中入度为 0 的节点，以及仅由入度为 0 节点所指向的节点。
        而本题是找到图中出度为 0 的节点，以及仅指向出度为 0 节点的节点。
         */
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] entry = new int[n];//当前点的入度
        List<List<Integer>> map = new ArrayList<List<Integer>>();//构造临接矩阵
        for(int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }
        for (int i=0;i<n;i++){
            int[] go = graph[i];
            for (int j=0;j<go.length;j++){
               map.get(go[j]).add(i);//原储存方式为起点到->终点  反图为终点->起点
            }
            entry[i]=graph[i].length;//反图中入度即原图的出度
        }
        System.out.println(Arrays.toString(entry));
        for (int i=0;i<n;i++){
            if (entry[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer first = queue.getFirst();
            queue.removeFirst();
            List<Integer> list = map.get(first);
            for (int i:list){
                entry[i]--;
                if (entry[i]==0){
                    queue.add(i);
                }
            }
        }
        return ans;
    }
}
