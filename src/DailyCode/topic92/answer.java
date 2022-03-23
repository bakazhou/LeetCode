package DailyCode.topic92;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class answer {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int begin = 1;
        ListNode temp = head;
        while (begin<left){
            temp=temp.next;
            begin++;
        }
        ListNode reverse = new ListNode(0);
        while (begin<=right){
            ListNode node = new ListNode(temp.val);
            node.next=reverse.next;
            reverse.next=node;
            begin++;
            temp=temp.next;
        }
        ListNode tail = reverse;
        while (tail.next!=null) tail=tail.next;
        tail.next = temp;
        if (left==1) return reverse.next;
        ListNode front = head;
        for (int i=1;i<left-1;i++){
            front=front.next;
        }
        front.next=reverse.next;
        return head;

    }
}
