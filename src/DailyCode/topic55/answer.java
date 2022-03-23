package DailyCode.topic55;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class answer {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int right = TreeDeepth(root.right),left = TreeDeepth(root.left);
        return Math.abs(right-left)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int TreeDeepth(TreeNode node){
        int deep = 0;
        if (node==null) return 0;
        LinkedList<TreeNode> tree = new LinkedList<>();
        tree.add(node);
        while (!tree.isEmpty()){
            deep++;
            int n = tree.size();
            for (int i=0;i<n;i++){
                TreeNode node1 = tree.getFirst();
                tree.removeFirst();
                if (node1.right!=null) tree.add(node1.right);
                if (node1.left!=null) tree.add(node1.left);
            }
        }
        return deep;
    }

}
