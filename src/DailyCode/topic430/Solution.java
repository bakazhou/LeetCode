package DailyCode.topic430;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
public class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        while (head != null) {
            if (head.child == null) {
                head = head.next;
            } else {
                Node tem = head.next;//稍后用于连接,暂存head.next
                Node child = flatten(head.child);
                child.prev = head;
                head.child = null;
                head.next = child;
                while (head.next!=null){
                    head = head.next;
                }
                head.next = tem;
                if (tem!=null){
                    tem.prev = head;
                }
                head = head.next;
            }
        }
        return dummy.next;
    }

}
