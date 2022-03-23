package DailyCode.topic515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size(),max = Integer.MIN_VALUE;
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                if (node.val>=max) max = node.val;
            }
            list.add(max);
        }
        return list;
    }
}
