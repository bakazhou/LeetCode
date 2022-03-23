package DailyCode.topic203;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class answer {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode();
        ListNode tem = node;
        while (head!=null){
            if (head.val!=val){
                tem.next=new ListNode(head.val);
                tem=tem.next;
            }
            head=head.next;
        }
        return node;
    }
}
