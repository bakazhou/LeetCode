package DailyCode.topic797.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        ans = new ArrayList<>();
        int end = graph.length-1;
        LinkedList<Integer> road = new LinkedList<>();
        road.add(0);
        dfs(road,0,graph,end);
        return ans;
    }
    public void dfs(LinkedList<Integer> road,int index,int[][] graph,int end){
        System.out.println();
        if (index==end){
            ans.add(new ArrayList<>(road));
        }
        int[] next = graph[index];
        for (int i=0;i<next.length;i++){
            road.add(next[i]);
            dfs(road, next[i], graph, end);
            road.removeLast();
        }
    }
}
