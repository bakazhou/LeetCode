package DailyCode.topic83;


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        ListNode ans = new ListNode(0);
        ListNode go = ans;
        while (node!=null){
            if (!set.contains(node.val)){
             set.add(node.val);
             ListNode temp = new ListNode(node.val);
             go.next=temp;
             go=go.next;
            }
            node=node.next;
        }
        return ans.next;
    }
}
