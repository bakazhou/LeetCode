package DailyCode.topic2049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��10�� 22:13
 **/
class Solution {
    public int countHighestScoreNodes(int[] parents) {
        //�÷�Ϊ�����Ĵ�С
        //ʵ���Ͼ���ɾ��һ���ڵ㽫���ٳ�,Ȼ������ʣ�������Ĵ�С��˼���
        Map<Integer, List<Integer>> map = new HashMap();
        int[] count = new int[parents.length];
        for(int i = 1; i < parents.length; i++){
            List<Integer> list = new ArrayList(map.getOrDefault( parents[i], new ArrayList()));
            list.add(i);
            map.put(parents[i], list);
        }
        DFS(0, map, count);
        long scoreMax = Integer.MIN_VALUE;
        int nodes = 0;
        for(int i = 0; i < parents.length; i++){
            long score = 1;
            //���ڸ��ڵ�
            if(parents[i] == -1){
                List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
                for(int num : list) {
                    score *= count[num];
                }
            }else{
                score = count[0] - count[i];
                List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
                for(int num : list) {
                    score *= count[num];
                }
            }
            if(scoreMax < score){
                scoreMax = score;
                nodes = 1;
            }else if(score == scoreMax) {
                ++nodes;
            }
        }
        return nodes;
    }

    public void DFS(int index,  Map<Integer, List<Integer>> map, int[] count){
        List<Integer> list = new ArrayList( map.getOrDefault( index, new ArrayList() ) );
        if(list.size() == 0){
            count[index] = 1;
            return;
        }
        for(int num : list){
            DFS(num, map, count);
            count[index] += count[num];
        }
        ++count[index];
    }
}
