package DailyCode.topic78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
nums = [1,2,3]
[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class answer {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        LinkedList<Integer> tem = new LinkedList<>();
        backtrack(nums,0,tem);
        return ans;
    }
    public void backtrack(int[] nums,int index,LinkedList<Integer> tem){
        if (index==nums.length) return;
        ans.add(new ArrayList<>(tem));
        for (int i=index;i<nums.length;i++){
            tem.add(nums[i]);
            backtrack(nums, i+1, tem);
            tem.removeLast();
        }
    }
}
