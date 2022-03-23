package DailyCode.topic662;

import java.util.LinkedList;

public class answer {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null) return 0;
        int width = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size(),w=0;
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                if (node.left==null || node.right!=null) w=w+2;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            if (!queue.isEmpty()){
                if (w>width) width=w;
            }
        }
        return width;
    }
}
