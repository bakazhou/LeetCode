package DailyCode.topic114;
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
    TreeNode tree;
    TreeNode temp;
    public void flatten(TreeNode root) {
        tree = new TreeNode();
        temp = tree;
        dfs(root);
        if (tree.right==null) return;
        root.left=null;
        root.right=tree.right.right;
    }
    public void dfs(TreeNode root){
        if (root==null) return;
        temp.right = new TreeNode(root.val);
        temp=temp.right;
        if (root.left!=null) dfs(root.left);
        if (root.right!=null) dfs(root.right);
    }
}
