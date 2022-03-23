package DailyCode.topic86;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class answer {
    public ListNode partition(ListNode head, int x) {
        /*
        构建两条新链表
        1.一条用来存小于x的数，一条用来存正常的数
         */
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode n1 = node1;
        ListNode n2 = node2;
        while (head!=null){
            if (head.val<x){
                n1.next=new ListNode(head.val);
                n1=n1.next;
            }else {
                n2.next=new ListNode(head.val);
                n2=n2.next;
            }
            head=head.next;
        }
        n1.next=node2.next;
        return node1.next;
    }
}
