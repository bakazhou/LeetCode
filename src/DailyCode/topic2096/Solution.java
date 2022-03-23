package DailyCode.topic2096;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��07�� 14:06
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
        //����������Ľڵ�����
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
        //ת��Ϊͼ�ķ�ʽ���
        //�涨0�������ͨ 1����Ϊ���ӹ�ϵ 2�������ӽڵ� 3�������ӽڵ�
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
        //���ڼ�¼·��
        LinkedList<String> road = new LinkedList<>();
        //���ڼ�¼��ǰ�ڵ�����
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