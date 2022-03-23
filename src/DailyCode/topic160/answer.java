package DailyCode.topic160;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class answer {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alength = 0,Blength = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (A!=null){
            Alength++;
            A = A.next;
        }
        while (B!=null){
            Blength++;
            B = B.next;
        }
        A = headA;
        B = headB;
        int n = Math.abs(Alength-Blength);
        if (Alength>Blength){
            while (n!=0){
                B=B.next;
                n--;
            }
        }else {
            while (n!=0){
                A=A.next;
                n--;
            }
        }
        System.out.println(A.val);
        System.out.println(B.val);
        while (A!=null && B!=null){
            if (A==B){
                return A;
            }
            A=A.next;
            B=B.next;
        }
        return null;
    }
}
