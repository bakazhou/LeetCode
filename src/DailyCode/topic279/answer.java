package DailyCode.topic279;

import java.util.LinkedList;
public class answer {
    public int numSquares(int n) {
        int step=0;
        boolean[] flag = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i=0;i<size;i++){
                int val = queue.getFirst();
                queue.removeFirst();
                for (int j=1;j*j<=val;j++){
                    int num = val-j*j;
                    if (num==0){
                        return step;
                    }
                    if (flag[num]==false){
                        queue.add(num);
                        flag[num]=true;
                    }
                }
            }
        }
        return n;
    }

}
