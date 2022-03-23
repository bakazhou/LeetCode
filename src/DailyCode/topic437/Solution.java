package DailyCode.topic437;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return -1;
        }
        dfs(root,targetSum);
        return ans;
    }
    public void dfsVal(TreeNode root, int targetSum, int cur){
        System.out.println(cur);
        if (cur == targetSum){
            ans++;
            return;
        }
        if (root == null || cur>targetSum){
            return;
        }
        if (root.left!=null){
            dfsVal(root.left, targetSum, cur+root.left.val);
        }
        if (root.right!=null){
            dfsVal(root.right, targetSum, cur+root.right.val);
        }
    }
    public void dfs(TreeNode root,int targetSum){
        dfsVal(root,targetSum,root.val);
        if (root.left!=null){
            dfs(root.left,targetSum);
        }
        if (root.right!=null){
            dfs(root.right,targetSum);
        }
    }
}
