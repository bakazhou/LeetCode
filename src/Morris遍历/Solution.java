package Morris����;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
������ǰ�ڵ�Ϊcur��

һ.���cur�����ӣ�cur�����ƶ���cur=cur.right��
��.���cur�����ӣ��ҵ�cur�����������ҵĽڵ㣬��Ϊmostright
    1.���mostright��rightָ��ָ��գ�����ָ��cur��cur�����ƶ���cur=cur.left��
    2.���mostright��rightָ��ָ��cur������ָ��գ�cur�����ƶ���cur=cur.right��
    ʵ�����ϵ�ԭ�򣬼�ʵ����morris������
 */
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
    public void Morris(TreeNode root){
        if (root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur!=null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){//�Ѿ��ҵ����������ҽڵ�
                    mostRight.right = cur;//�����ҽڵ����ָ��ָ��cur
                    cur = cur.left;//cur�����ƶ�
                    continue;
                }else {//mostRight�Ѿ�ָ��cur
                    mostRight.right = null;//��cur��Ϊ��
                }
            }
            cur = cur.right;
        }
        System.out.println(list);
    }
}
