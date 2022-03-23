package DailyCode.topic2096;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月07日 14:06
 **/
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
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null){
            return "";
        }
        //求出二叉树的节点数量
        int size = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            size += n;
            for (int i=0;i<n;i++){
                TreeNode first = queue.getFirst();
                queue.removeFirst();
                if (first.left!=null){
                    queue.add(first.left);
                }
                if (first.right!=null){
                    queue.add(first.right);
                }
            }
        }
        //转变为图的方式求解
        //规定0代表非连通 1代表为父子关系 2代表左子节点 3代表右子节点
        int[][] graph = new int[size+1][size+1];
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            size += n;
            for (int i=0;i<n;i++){
                TreeNode first = queue.getFirst();
                queue.removeFirst();
                if (first.left!=null){
                    queue.add(first.left);
                    graph[first.val][first.left.val] = 2;
                    graph[first.left.val][first.val] = 1;
                }
                if (first.right!=null){
                    queue.add(first.right);
                    graph[first.val][first.right.val] = 3;
                    graph[first.right.val][first.val] = 1;
                }
            }
        }
        //用于记录路径
        LinkedList<String> road = new LinkedList<>();
        //用于记录当前节点数字
        LinkedList<Integer> num = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        road.add("");
        num.add(startValue);
        set.add(startValue);
        while (!road.isEmpty()){
            int n = road.size();
            for (int i=0;i<n;i++){
                int first = num.getFirst();
                num.removeFirst();
                String roadFirst = road.getFirst();
                road.removeFirst();
                if (first == destValue){
                    return roadFirst;
                }
                int[] go = graph[first];
                for (int j=0;j<go.length;j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(roadFirst);
                    if (go[j] == 1 || go[j] == 2 || go[j] == 3 && !set.contains(j)){
                        set.add(j);
                        num.add(j);
                        if (go[j] == 1){
                            sb.append('U');
                        }
                        else if (go[j] == 2){
                            sb.append('L');
                        }
                        else if (go[j] == 3){
                            sb.append('R');
                        }
                        road.add(sb.toString());
                    }
                }
            }
        }
        return "";
    }
}