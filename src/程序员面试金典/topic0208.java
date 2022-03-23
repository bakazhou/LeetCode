package ����Ա���Խ��;

import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��08�� 10:48
 **/
public class topic0208 {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && slow.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
