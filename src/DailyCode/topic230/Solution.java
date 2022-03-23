package DailyCode.topic230;

import java.util.ArrayList;
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
public class Solution {
    List<Integer> list;
    //�����������е�KС��Ԫ��
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        //ֱ�ӽ��������������
        //����������������ֻ��С�ڽڵ�ֵ��������ֻ����ڵ�ǰ�ڵ�ֵ�����԰������Ҹ���˳�����������ҵ��ĵ����˳������õ���
        dfs(root);
        return list.get(k);
    }
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        if (root.left!=null){
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right!=null){
            dfs(root.right);
        }
    }
}
