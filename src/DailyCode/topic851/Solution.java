package DailyCode.topic851;

import 程序员面试金典.ListNode;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月15日 11:23
 **/
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0;i<richer.length;i++){
            if (!map.containsKey(richer[i][1])){
                Set<Integer> set = new HashSet<>();
                set.add(richer[i][0]);
                map.put(richer[i][1],set);
            }else {
                map.get(richer[i][1]).add(richer[i][0]);
            }
        }
        int[] ans = new int[quiet.length];
        Arrays.fill(ans,-1);
        for (int i=0;i<quiet.length;i++){
            dfs(quiet,i,map,ans);
        }
        return ans;
    }
    public void dfs(int[] quiet,int n,Map<Integer, Set<Integer>> map,int[] ans){
        if (ans[n] != -1){
            return;
        }
        ans[n] = n;
        if (map.containsKey(n)){
            Set<Integer> set = map.get(n);
            for (int key : set){
                dfs(quiet,key,map,ans);
                if (quiet[ans[key]] <= quiet[ans[n]]){
                    ans[n] = ans[key];
                }
            }
        }
    }
}
