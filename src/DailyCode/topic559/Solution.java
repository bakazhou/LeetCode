package DailyCode.topic559;

import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution {
    public int maxDepth(Node root) {
        int layer = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i=0;i<n;i++){
                Node first = queue.getFirst();
                if (!first.children.isEmpty()){
                    for (Node node : first.children){
                        queue.add(node);
                    }
                }
                queue.removeFirst();
            }
            layer++;
        }
        return layer;
    }
}