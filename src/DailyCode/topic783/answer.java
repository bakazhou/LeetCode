package DailyCode.topic783;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
    public int minDiffInBST(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root==null) return 0;
        queue.add(root);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                list.add(node.val);
                if (node.right!=null) queue.add(node.right);
                if (node.left!=null) queue.add(node.left);
            }
        }
        Collections.sort(list);
        for (int i=0;i<list.size()-1;i++){
            min=Math.min(min,list.get(i+1)-list.get(i));
        }
        return min;
    }
    List<Integer> list = new ArrayList<>();
    public int minDiffInBST1(TreeNode root) {
        dfs(root);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i=0;i<list.size()-1;i++){
            min=Math.min(min,list.get(i+1)-list.get(i));
        }
        return min;
    }
    public void dfs(TreeNode node){
        if (node==null) return;
        list.add(node.val);
        if (node.right!=null) dfs(node.right);
        if (node.left!=null) dfs(node.left);
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String ab= a + b;
        ab.intern();
        String ab1 = "ab";
        System.out.println(ab==ab1);
    }
}
