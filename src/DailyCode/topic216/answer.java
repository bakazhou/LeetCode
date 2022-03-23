package DailyCode.topic216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    List<List<Integer>> ans;
    int[] num = {1,2,3,4,5,6,7,8,9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(list,visited,0,n,0,k);
        return ans;
    }
    public void backtrack(LinkedList<Integer> list,boolean[] visited,int cur,int n,int index,int k){
        if (cur==n && list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i=index;i<num.length;i++){
            if (visited[i]) continue;
            visited[i]=true;
            list.add(num[i]);

            backtrack(list, visited, cur+num[i], n, i,k);

            visited[i]=false;
            list.removeLast();
        }
    }
}
