package DailyCode.topic2059;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        int step = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            System.out.println(queue);
            for (int j=0;j<n;j++){
                int cur = queue.getFirst();
                if (cur == goal){
                    return step;
                }
                queue.removeFirst();
                for (int i=0;i<nums.length;i++){
                    int t1 = cur+nums[i];
                    int t2 = cur-nums[i];
                    int t3 = cur^nums[i];
                    if (t1>1000 || t1<0){
                        if (t1==goal){
                            return step;
                        }
                    }else {
                        if (set.contains(t1)){
                            set.add(t1);
                            queue.add(t1);
                        }
                    }
                    if (t2>1000 || t2<0){
                        if (t2==goal){
                            return step;
                        }
                    }else {
                        if (set.contains(t2)){
                            set.add(t2);
                            queue.add(t2);
                        }
                    }
                    if (t3>1000 || t3<0){
                        if (t3==goal){
                            return step;
                        }
                    }else {
                        if (set.contains(t3)){
                            set.add(t3);
                            queue.add(t3);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
