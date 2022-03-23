package ����Ա���Խ��;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��09�� 12:52
 **/
public class topic0804 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums,list,0,ans);
        return ans;
    }
    public void dfs(int[] nums,  LinkedList<Integer> list,int index,List<List<Integer>> ans){
        ans.add(new LinkedList<>(list));
        for (int i=index;i<nums.length;i++){
            list.add(nums[i]);
            dfs(nums, list, index+1,ans);
            list.remove(list.size() - 1);
        }
    }
}
