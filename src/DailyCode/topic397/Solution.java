package DailyCode.topic397;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int integerReplacement(int n) {
        if (n == 1){
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int num = queue.getFirst();
                if (num == 1){
                    return steps+1;
                }
                helper(num,set,queue);
                queue.removeFirst();
            }
            steps++;
        }
        return steps;
    }
    public void helper(int n,HashSet<Integer> set,LinkedList<Integer> queue){
        /*
        如果 n 是偶数，则用 n / 2替换 n 。
        如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
         */
        if (n%2==0){//偶数
            int num = n/2;
            if (!set.contains(num)){
                queue.add(num);
                set.add(num);
            }
        }else {//奇数
            if (!set.contains(n-1)){
                queue.add(n-1);
                set.add(n-1);
            }
            if (n<Integer.MAX_VALUE && !set.contains(n+1)){
                queue.add(n+1);
                set.add(n+1);
            }
        }
    }
}