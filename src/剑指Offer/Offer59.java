package 剑指Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer59 {
}
class MaxQueue {
    int[] memo;
    int index,end,size;
    public MaxQueue() {
        memo =new int[100001];
        init();
    }
    public void init(){
        index=0;
        size=0;
        end=0;
    }
    public int max_value() {
        if (size==0){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i=index;i<end;i++){
            if (memo[i]>=max){
                max = memo[i];
            }
        }
        return max;
    }

    public void push_back(int value) {
        memo[end]=value;
        end++;
        size++;
    }

    public int pop_front() {
        if (size==0){
            return -1;
        }
        size--;
        int pop= memo[index];
        index++;


        return pop;
    }
}