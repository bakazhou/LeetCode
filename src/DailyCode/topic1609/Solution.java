package DailyCode.topic1609;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��25�� 15:30
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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode first = queue.getFirst();
                list.add(first.val);
                queue.removeFirst();
                if (first.left!=null){
                    queue.add(first.left);
                }
                if (first.right!=null){
                    queue.add(first.right);
                }
            }
            if (!judge(list,level)){
                return false;
            }
            level++;
        }
        return false;
    }
    //ż���±� ���ϵ����нڵ��ֵ���� �� �����������Ұ�˳�� �ϸ����
    //�����±� ���ϵ����нڵ��ֵ���� ż �����������Ұ�˳�� �ϸ�ݼ�
    public boolean judge(List<Integer> list,int flag){
        if (list.isEmpty()){
            return true;
        }
        if (flag%2 == 0){
            if (list.get(0)%2 == 0){
                return false;
            }
            for (int i=1;i<list.size();i++){
                if (list.get(i)%2 == 0){
                    return false;
                }
                if (list.get(i) <= list.get(i-1)){
                    return false;
                }
            }
        }else {
            if (list.get(0)%2 != 0){
                return false;
            }
            for (int i=1;i<list.size();i++){
                if (list.get(i)%2 != 0){
                    return false;
                }
                if (list.get(i) >= list.get(i-1)){
                    return false;
                }
            }
        }
        return true;
    }
}