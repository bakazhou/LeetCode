package DailyCode.topic725;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode node = head;
        ListNode[] ans = new ListNode[k];;
        while (node!=null){
            length++;
            node = node.next;
        }
        node = head;
        if (length<=k){
            int index = 0;
            while (node!=null){
                ans[index] = new ListNode(node.val);
                index++;
            }
        }else {
            int capa = length/k;//每节的容量
            int surplus = length%k;//多余节点
            for (int i=0;i<k;i++){
                ListNode tem = new ListNode();
                ListNode temHead = tem;
                if (surplus!=0){//多余节点剩余数量
                    for (int j=0;j<capa+1;j++){ 
                        ListNode temNode = new ListNode(node.val);
                        temHead.next = temNode;
                        temHead = temHead.next;
                        node = node.next;
                    }
                }else {
                    for (int j=0;j<capa;j++){
                        ListNode temNode = new ListNode(node.val);
                        temHead.next = temNode;
                        temHead = temHead.next;
                        node = node.next;
                    }
                }
                ans[i] = tem.next;
            }
        }
        return ans;
    }
}
