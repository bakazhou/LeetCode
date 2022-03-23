package DailyCode.test0206;

import java.util.LinkedList;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class answer {
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        LinkedList<Integer> list = new LinkedList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        while (!list.isEmpty() && list.size()!=1){
            Integer first = list.getFirst();
            Integer last = list.getLast();
            list.removeFirst();
            list.removeLast();
            if (first!=last) return false;
        }
        return true;
    }
}
