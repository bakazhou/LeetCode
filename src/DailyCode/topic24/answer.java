package DailyCode.topic24;


import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class answer {
    public ListNode swapPairs(ListNode head) {
        int k=2;
        int length=0;
        ListNode temp = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (temp!=null){
            length++;
            listNodes.add(temp);
            temp=temp.next;
        }
        if(length<=1) return head;
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        int times = length/k;
        int location = 0;
        while (times!=0){
            int index =location;
            location+=k;
            for (int i=location-1;i>=index;i--){
                ListNode headNode = listNodes.get(i);
                ListNode node = new ListNode(headNode.val);
                tail.next=node;
                tail=tail.next;
            }
            times--;
        }
        if (length%k!=0){
            for (int i=location;i<listNodes.size();i++){
                ListNode headNode = listNodes.get(i);
                ListNode node = new ListNode(headNode.val);
                tail.next=node;
                tail=tail.next;
            }
        }
        return ans.next;
    }
}
