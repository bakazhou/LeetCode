package DailyCode.topic2095;


import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ07ÈÕ 13:59
 **/
    class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null){
            length++;
            tmp = tmp.next;
        }
        if (length == 1){
            return head.next;
        }
        ListNode node = head;
        for (int i=0;i<length/2-1;i++){
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}