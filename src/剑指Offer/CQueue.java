package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;//stack1的倒序
    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int n;
        if (stack2.isEmpty()){
            return -1;
        }else {
            n = stack2.pop();
        }
        return n;
    }
}
