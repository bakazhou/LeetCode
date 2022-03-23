package DailyCode.topic5927;


class ListNode {
    int val;
    ListNode next;
    ListNode() {  }
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null){
            return head;
        }
        int length = 0;//链表长度
        ListNode h = head;
        while (h!=null){
            length++;
            h = h.next;
        }
        int size = 1,useSize = 0;//当前需要节点数量 和已经使用的数量
        ListNode newHead = new ListNode();
        ListNode node = newHead;
        while (head != null){
            //偶数,需要利用头插法
            if ((size%2==0 && size>=length-useSize) || (size<length-useSize && (length-useSize)%2==0)){
                System.out.println(length-useSize);
                for (int i=0;i<size && head!=null;i++){
                    ListNode tNode = new ListNode(head.val);
                    tNode.next = node.next;
                    node.next = tNode;
                    head = head.next;
                }
                while (node.next!=null){
                    node = node.next;
                }
            }
            else if ((size%2!=0 && size>=length-useSize) || (size<length-useSize && (length-useSize)%2!=0)){
                System.out.println(length-useSize);
                //奇数直接添加在后面即可
                for (int i=0;i<size && head!=null;i++){
                    ListNode tNode = new ListNode(head.val);
                    node.next = tNode;
                    node = node.next;
                    head = head.next;
                }
            }
            useSize += size;
            size++;
        }
        return newHead.next;
    }
}