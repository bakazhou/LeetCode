package DailyCode.topic111;

import java.util.LinkedList;

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
    public int minDepth(TreeNode root) {
        int deepth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null) return 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            deepth++;
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                if (node.left==null && node.right==null) return deepth;
            }
        }
        return deepth;
    }
}
