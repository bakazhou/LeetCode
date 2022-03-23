package DailyCode.topic199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    List<Integer> nums;
    public List<Integer> rightSideView(TreeNode root) {
        nums = new ArrayList<>();
        if (root==null) return nums;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            TreeNode treeNode = queue.getLast();
            nums.add(treeNode.val);
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
