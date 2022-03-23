package DailyCode.topic222;

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
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nums = 0;
        while (!queue.isEmpty()){
            int n=queue.size();
            nums+=n;
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return nums;
    }
}
