package DailyCode.topic992;

import java.util.*;

public class answer {
    public int subarraysWithKDistinct(int[] A, int K) {
        if (A.length<=1){
            return 1;
        }
        Queue queue = new LinkedList();
        Vector<LinkedList> listVector = new Vector<>();
        int left = 0,right = 0,n = 0;
        while (right<A.length && left<A.length){
            if (n<K){
                if (!queue.contains(A[right])) {
                    n++;
                }
                queue.offer(A[right]);
                right++;
            }else {//其中含有元素已经大于K个
                if (!queue.contains(A[right])){
                    int a = (int) queue.poll();
                    if (!queue.contains(a)){
                        n--;
                    }
                }else {
                    queue.offer(A[right]);
                    right++;
                }
            }
            if (n==K) {
                System.out.println(Arrays.toString(queue.toArray()));
                listVector.add((LinkedList) queue);
            }
        }
        return listVector.size();
    }
}
