package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> road = new LinkedList<>();
        if (root==null){
            return ans;
        }
        dfs(root,target,road,0);
        return ans;
    }
    public void dfs(TreeNode root,int target,LinkedList<Integer> road,int cur){
        cur+=root.val;
        road.add(root.val);
        if (root.left==null && root.right==null){
            if (cur==target){
                ans.add(new ArrayList<>(road));
            }
            road.removeLast();
            return;
        }
        if (root.left!=null){
            dfs(root.left, target, road, cur);
        }
        if (root.right!=null){
            dfs(root.right, target, road, cur);
        }
    }
}
