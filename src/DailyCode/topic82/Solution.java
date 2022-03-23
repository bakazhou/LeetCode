package DailyCode.topic82;

import java.util.HashMap;
import java.util.Map;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        ListNode temp = head;
        while (temp!=null){
            if (!map.containsKey(temp.val)){
                map.put(temp.val,1);
            }else {
                map.put(temp.val,map.get(temp.val)+1);
            }
            temp=temp.next;
        }
        ListNode node1 = head;
        while (node1!=null){
            if (map.get(node1.val)==1){
                node.next=new ListNode(node1.val);
                node=node.next;
            }
            node1=node1.next;

        }
        return ans.next;
    }
}
