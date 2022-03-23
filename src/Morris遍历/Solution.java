package Morris遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
记作当前节点为cur。

一.如果cur无左孩子，cur向右移动（cur=cur.right）
二.如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
    1.如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
    2.如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
    实现以上的原则，即实现了morris遍历。
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
                if (mostRight.right == null){//已经找到左子树最右节点
                    mostRight.right = cur;//将最右节点的右指针指向cur
                    cur = cur.left;//cur向左移动
                    continue;
                }else {//mostRight已经指向cur
                    mostRight.right = null;//将cur置为空
                }
            }
            cur = cur.right;
        }
        System.out.println(list);
    }
}
