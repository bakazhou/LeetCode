package DailyCode.topic61;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return null;
        int length = 0;
        ListNode node = head;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while (node!=null){
            length++;
            node=node.next;
        }
        int num1 = k%length;
        int num2 = length-num1;
        node=head;
        for (int i=0;i<num2;i++){
            temp.next = new ListNode(node.val);
            temp=temp.next;
            node=node.next;
        }
        ListNode ans1 = new ListNode(0);
        ListNode temp1 = ans1;
        for (int j=0;j<num1;j++){
            temp1.next = new ListNode(node.val);
            temp1=temp1.next;
            node=node.next;
        }
        temp1.next=temp.next;
        return ans1.next;
    }
}
