package DailyCode.topic802;

import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        /*
        �����������ҵ�ͼ�����Ϊ 0 �Ľڵ㣬�Լ��������Ϊ 0 �ڵ���ָ��Ľڵ㡣
        ���������ҵ�ͼ�г���Ϊ 0 �Ľڵ㣬�Լ���ָ�����Ϊ 0 �ڵ�Ľڵ㡣
         */
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] entry = new int[n];//��ǰ������
        List<List<Integer>> map = new ArrayList<List<Integer>>();//�����ٽӾ���
        for(int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }
        for (int i=0;i<n;i++){
            int[] go = graph[i];
            for (int j=0;j<go.length;j++){
               map.get(go[j]).add(i);//ԭ���淽ʽΪ��㵽->�յ�  ��ͼΪ�յ�->���
            }
            entry[i]=graph[i].length;//��ͼ����ȼ�ԭͼ�ĳ���
        }
        System.out.println(Arrays.toString(entry));
        for (int i=0;i<n;i++){
            if (entry[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer first = queue.getFirst();
            queue.removeFirst();
            List<Integer> list = map.get(first);
            for (int i:list){
                entry[i]--;
                if (entry[i]==0){
                    queue.add(i);
                }
            }
        }
        return ans;
    }
}
