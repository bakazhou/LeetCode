package DailyCode.topic129;

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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        dfs(0,root);
        return ans;
    }
    public void dfs(int num,TreeNode root){
        num=num*10+root.val;
        System.out.println(num);
        if (root.left==null && root.right==null){
            ans+=num;
            return;
        }
        if (root.left!=null){
            dfs(num,root.left);
        }
        if (root.right!=null){
            dfs(num,root.right);
        }
    }
}
