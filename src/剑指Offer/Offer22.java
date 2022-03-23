package ½£Ö¸Offer;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        for (int i=0;i<k;i++){
            node=node.next;
        }
        ListNode ans = head;
        while(node!=null){
            ans=ans.next;
            node=node.next;
        }
        return ans;
    }
}
