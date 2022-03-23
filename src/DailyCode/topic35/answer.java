package DailyCode.topic35;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class answer {
    public Node copyRandomList(Node head) {
        Map<Integer,Node> map = new HashMap<>();//记录新链表中节点所在的位置
        Node ans = new Node(0);
        Node temp = ans;
        Node head1 = head;
        int index = 0;
        while (head1!=null){//构建一条新链表
            Node node = new Node(head1.val);
            node.next =temp.next;
            temp.next=node;
            temp=temp.next;
            head1=head1.next;
            map.put(index,node);
            index++;
        }
        head1=head;
        index=0;
        Map<Integer,Integer> map1 = new HashMap<>();//记录老链表中的每个节点对应的random的值
        while (head1!=null){
            if (head1.random==null) map1.put(index,null);
            else {
                int location=0;
                Node head2 = head;
                while (head2!=head1.random){
                    location++;
                    head2=head2.next;
                }
                map1.put(index,location);
            }
            index++;
            head1=head1.next;
        }
        temp=ans;
        index=0;
        while (temp!=null){
            if (map1.get(index)!=null){
                temp.random=map.get(map1.get(index));
            }else temp.random=null;
            index++;
            temp=temp.next;
        }
        return ans.next;
    }
}
