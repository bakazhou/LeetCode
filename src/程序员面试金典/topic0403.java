package 程序员面试金典;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月08日 11:16
 **/
public class topic0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        ListNode[] ans;
        if (tree == null){
            ans = new ListNode[0];
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<ListNode> listNodeList = new ArrayList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            int n = queue.size();
            ListNode head = new ListNode();
            ListNode node = head;
            for (int i=0;i<n;i++){
                TreeNode first = queue.getFirst();
                ListNode tmp = new ListNode(first.val);
                node.next = tmp;
                node = node.next;
                queue.removeFirst();
                if (first.left != null){
                    queue.add(first.left);
                }
                if (first.right != null){
                    queue.add(first.right);
                }
            }
            if (head.next != null){
                listNodeList.add(head.next);
            }
        }
        ans = new ListNode[listNodeList.size()];
        for (int i=0;i<listNodeList.size();i++){
            ans[i] = listNodeList.get(i);
        }
        return ans;
    }
}
