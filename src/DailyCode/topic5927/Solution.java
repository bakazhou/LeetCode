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
        int length = 0;//������
        ListNode h = head;
        while (h!=null){
            length++;
            h = h.next;
        }
        int size = 1,useSize = 0;//��ǰ��Ҫ�ڵ����� ���Ѿ�ʹ�õ�����
        ListNode newHead = new ListNode();
        ListNode node = newHead;
        while (head != null){
            //ż��,��Ҫ����ͷ�巨
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
                //����ֱ������ں��漴��
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