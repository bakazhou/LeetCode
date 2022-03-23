package DailyCode.topic700;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root,val);
    }
    public TreeNode dfs(TreeNode root,int val) {
        System.out.println(root.val);
        if (root.val == val) {
            return root;
        } else if (val > root.val) {
            if (root.left != null) {
                return dfs(root.left, val);
            }
        } else if (val < root.val) {
            if (root.right != null) {
                return dfs(root.right, val);
            }
        }
        return null;
    }
}