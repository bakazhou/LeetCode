package DailyCode.topic2058;



import java.util.ArrayList;
import java.util.List;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        if (head == null){
            return new int[]{-1,-1};
        }
        while (head!=null){
            nodes.add(new ListNode(head.val));
            head = head.next;
        }
        if (nodes.size()<=2){//链表小于两个
            return new int[]{-1,-1};
        }
        List<Integer> indexs = new ArrayList<>();
        for (int i=1;i<nodes.size()-1;i++){
            int pre = nodes.get(i-1).val;
            int next = nodes.get(i+1).val;
            int num = nodes.get(i).val;
            if ((num > pre && num > next) || (num < pre && num < next)){
                indexs.add(i);
            }
        }
        if (indexs.size()<2){
            return new int[]{-1,-1};
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<indexs.size()-1;i++){
            if (indexs.get(i+1)-indexs.get(i)<min){
                min = indexs.get(i+1)-indexs.get(i);
            }
        }
        return new int[]{min,indexs.get(indexs.size()-1)-indexs.get(0)};
    }
}
