package DailyCode.topic734;

import java.util.Arrays;
import java.util.LinkedList;

public class answer {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] map = new int[n+1][n+1];
        boolean[] flag = new boolean[n+1];
        for (int i=0;i<map.length;i++){
            Arrays.fill(map[i],-1);
        }
        int ans = 0;
        for (int i=0;i<times.length;i++){
            int[] road = times[i];
            map[road[0]][road[1]]=road[2];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(k);
        while (!queue.isEmpty()){
            int cap = queue.size();
            int max = 0;
            for (int i=0;i<cap;i++){
                int head = queue.getFirst();
                queue.removeFirst();
                if (!flag[head]){//˵������㻹û�з��ʹ��������������ܷ��ʵĵ�
                    flag[head] = true;
                    int[] road = map[head];
                    for (int j=1;j<road.length;j++){
                        if (road[j]!=-1 && !flag[j]){//˵����·������
                            max = Math.max(max,road[j]);
                            queue.add(j);
                        }
                    }
                }
            }
            ans+=max;
        }
        for (int i=1;i<flag.length;i++){
            if (!flag[i]) {//û�з��ʵ������
                return -1;
            }
        }
        return ans;
    }
}
