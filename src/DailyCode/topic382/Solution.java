package DailyCode.topic382;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ20ÈÕ 14:57
 **/
class ListNode {
    int val;
   ListNode next;
    ListNode(){
    }
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    List<Integer> nodeVal;
    Random random;
    public Solution(ListNode head) {
        nodeVal = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            nodeVal.add(node.val);
            node = node.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return nodeVal.get(random.nextInt(nodeVal.size()));
    }

}
