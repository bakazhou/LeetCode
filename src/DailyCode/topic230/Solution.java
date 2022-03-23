package DailyCode.topic230;

import java.util.ArrayList;
import java.util.List;

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
    List<Integer> list;
    //二叉搜索树中第K小的元素
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        //直接进行中序遍历即可
        //二叉搜索树左子树只会小于节点值，右子树只会大于当前节点值，所以按照左右根的顺序来遍历，找到的点就是顺序遍历好的数
        dfs(root);
        return list.get(k);
    }
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        if (root.left!=null){
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right!=null){
            dfs(root.right);
        }
    }
}
