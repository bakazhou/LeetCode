package DailyCode.topic25;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class answer {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length=0;
        ListNode temp = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (temp!=null){
            length++;
            listNodes.add(temp);
            temp=temp.next;
        }
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
                node.next =temp.next;
                tail.next=node;
                tail=tail.next;
            }
        }
        if (length%k!=0){
            for (int i=location;i<listNodes.size();i++){
                ListNode headNode = listNodes.get(i);
                ListNode node = new ListNode(headNode.val);
                node.next =temp.next;
                tail.next=node;
                tail=tail.next;
            }
        }
        return ans.next;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
    }
}
