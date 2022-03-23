package DailyCode.topic47;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> tem = new LinkedList<>();
        backtrack(nums,visited,tem);
        return ans;
    }
    public void backtrack(int[] nums,boolean[] visted,LinkedList<Integer> tem){
        if (tem.size()==nums.length){
            if (!judge(tem)) ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i=0;i<visted.length;i++){
            if (visted[i]) continue;
            visted[i]=true;
            tem.add(nums[i]);
            backtrack(nums, visted, tem);
            visted[i]=false;//回溯
            tem.removeLast();
        }
    }
    public boolean judge(LinkedList<Integer> tem){
        for (int i=0;i<ans.size();i++){
            List<Integer> list = ans.get(i);
            boolean flag = true;
            for (int j=0;j<list.size();j++){
                if (list.get(j)!=tem.get(j)){
                    flag=false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }

}
