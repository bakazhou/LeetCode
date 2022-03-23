package DailyCode.topic113;
import java.util.ArrayList;
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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        LinkedList<Integer> road = new LinkedList<>();
        if (root==null) return ans;
        road.add(root.val);
        search(road,0,targetSum,root);
        return ans;
    }
    public void search(LinkedList<Integer> road,int sum,int target,TreeNode root){
        if (root.left==null && root.right==null){
            sum=sum+root.val;
            if (sum==target) {
                ans.add(new ArrayList<>(road));
                return;
            }
        }
        if (root.left!=null){
            road.add(root.left.val);
            search(road, sum+root.val, target, root.left);
            road.removeLast();
        }
        if (root.right!=null){
            road.add(root.right.val);
            search(road, sum+root.val, target, root.right);
            road.removeLast();
        }
    }
}
