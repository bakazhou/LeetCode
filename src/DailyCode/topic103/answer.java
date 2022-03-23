package DailyCode.topic103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null) return ans;
        int dir = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> num = new ArrayList<>();
            if (dir%2==0){
                for (int i=0;i<n;i++){
                    TreeNode node = queue.getFirst();
                    num.add(node.val);
                    queue.removeFirst();
                    if (node.left!=null) queue.add(node.left);
                    if (node.right!=null) queue.add(node.right);
                }
            }else {
                LinkedList<TreeNode> q1 = new LinkedList<>();
                for (int i=n-1;i>=0;i--){
                    TreeNode node = queue.getLast();
                    num.add(node.val);
                    queue.removeLast();
                }
                while (!q1.isEmpty()){
                    TreeNode node = q1.getFirst();
                    q1.removeFirst();
                    if (node.left!=null) queue.add(node.left);
                    if (node.right!=null) queue.add(node.right);
                }
            }
            dir++;
            ans.add(num);
        }
        return ans;
    }
}
