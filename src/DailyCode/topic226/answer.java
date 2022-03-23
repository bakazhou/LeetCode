package DailyCode.topic226;
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
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public void swap(TreeNode root){
        TreeNode temp = root.right;
        root.right=root.left;
        root.left=temp;
    }
    public void dfs(TreeNode root){
        swap(root);
        if (root.left!=null) dfs(root.left);
        if (root.right!=null) dfs(root.right);
    }
}
