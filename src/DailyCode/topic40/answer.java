package DailyCode.topic40;

import java.util.*;

public class answer {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        LinkedList<Integer> tem = new LinkedList<>();
        boolean[] visited = new boolean[candidates.length];
        backtrack(tem,visited,candidates,target,0,0);
        return ans;
    }
    public void backtrack(LinkedList<Integer> tem,boolean[] visited,int[] candidates, int target,int cur,int index){
        if (cur>target) return;
        if (cur==target){
            if (!judge(tem)) ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i=index;i<visited.length;i++){
            if (visited[i]) continue;
            visited[i]=true;
            tem.add(candidates[i]);
            backtrack(tem, visited, candidates, target, cur+candidates[i], i);
            visited[i]=false;
            tem.removeLast();
        }
    }
    public boolean judge(LinkedList<Integer> tem){
        for (int i=0;i<ans.size();i++){
            List<Integer> list = ans.get(i);
            boolean flag = true;
            Map<Integer,Integer> map1 = new HashMap<>();
            for (int j=0;j<list.size();j++){
                if (map1.get(list.get(j))==null) map1.put(list.get(j),1);
                else map1.put(list.get(j),map1.get(list.get(j))+1);
            }
            Map<Integer,Integer> map2 = new HashMap<>();
            for (int j=0;j<tem.size();j++){
                if (map2.get(tem.get(j))==null) map2.put(tem.get(j),1);
                else map2.put(tem.get(j),map2.get(tem.get(j))+1);
            }
            for (int j=0;j<tem.size();j++){
                if (map1.get(tem.get(j))==null || map1.get(tem.get(j))!=map2.get(tem.get(j))){
                    flag=false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}
