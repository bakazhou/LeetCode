package DailyCode.offerTopic24;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class answer {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode ans = new ListNode(0);
        ListNode tem = ans;
        while (head!=null){
            ListNode node = new ListNode(head.val);
            head=head.next;
            node.next=tem.next;
            tem.next=node;
        }
        return ans.next;
    }
}
