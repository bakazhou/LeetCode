package DailyCode.topic513;

import java.util.LinkedList;

public class answer {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null) return 0;
        int ans = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                if (i==0) ans=node.val;
            }
        }
        return ans;
    }
}
