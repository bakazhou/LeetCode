package DailyCode.topic630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��14�� 11:04
 **/
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        int res = 0,day = 0;
        //�Ѷ�������ǵ�ǰ�ķ�ʱ����Ŀγ�
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i=0;i<courses.length;i++){
            //��ǰ�γ̿���˳��ѧ��
            if (day+courses[i][0] <= courses[i][1]){
                day += courses[i][0];
                res++;
                q.offer(courses[i][0]);
                continue;
            }
            //��ǰ�γ��޷�˳��ѧ��,��Ҫ������֮ǰѧϰ�ķ�ʱ����Ŀγ�
            if (!q.isEmpty() && q.peek()>courses[i][0]){
                day -= q.poll();
                day += courses[i][0];
                q.offer(courses[i][0]);
            }
        }
        return res;
    }
}
