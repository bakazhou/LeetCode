package 剑指Offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        List<TreeNode> roots = new ArrayList<>();
        if (root==null) {
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        roots.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                if (node.left!=null){
                    queue.add(node.left);
                    roots.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                    roots.add(node.right);
                }
            }
        }
        int[] ans = new int[roots.size()];
        for (int i=0;i<roots.size();i++){
            ans[i]=roots.get(i).val;
        }
        return ans;
    }
}
