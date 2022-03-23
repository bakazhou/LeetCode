package DailyCode.topic39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        LinkedList<Integer> tem = new LinkedList<>();
        backtrack(tem,candidates,target,0,0);
        return ans;
    }
    public void backtrack(LinkedList<Integer> tem,int[] candidates, int target,int cur,int index){
        if (cur>target) return;
        if (cur==target){
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i=index;i<candidates.length;i++){
            tem.add(candidates[i]);
            backtrack(tem, candidates, target, cur+candidates[i],index);
            tem.removeLast();
        }
    }
}
