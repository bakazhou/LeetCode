package DailyCode.topic404;
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
public class answer {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        int sum = 0;
        if (root.left!=null){
            if (root.left.left==null && root.left.right==null) sum+=root.left.val;
            else sum+=dfs(root.left);
        }
        if (root.right!=null){
            sum+=dfs(root.right);
        }
        return sum;
    }
}
