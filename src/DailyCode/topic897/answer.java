package DailyCode.topic897;

public class answer {
    TreeNode ans;
    TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        ans = new TreeNode();
        ans.left=null;
        temp = ans;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if (root==null) return;
        if(root.left!=null){
            dfs(root.left);
        }
        temp.val=root.val;
        TreeNode node = new TreeNode();
        temp.right=node;
        temp=temp.right;
        if (root.right!=null){
            dfs(root.right);
        }
    }
}
