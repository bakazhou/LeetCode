package DailyCode.topic46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(list,nums);
        return ans;
    }
    public void backtrack(LinkedList<Integer> list, int[] nums){
        if (list.size()==nums.length){
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(list,nums);
            list.removeLast();
        }
    }
}
