package DailyCode.topic391;

import java.util.HashSet;
import java.util.Set;

/*
��1�������� ������ ������ ������ ���ĸ���ֻ����һ�� ������ɶԳ��� ��2���ĸ���Χ�ǵľ������ = С���ε����֮��
 */
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        //С���ε������
        int area = 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(int i=0;i<rectangles.length;i++){
            //�ĸ���ȫ���ҳ���
            //rectangles[i] = [xi, yi, ai, bi]
            int[] point = rectangles[i];
            left = Math.min(left, point[0]);
            down = Math.min(down, point[1]);
            right = Math.max(right, point[2]);
            top = Math.max(top, point[3]);
            //����С���������
            area += (point[2]-point[0])*(point[3]-point[1]);

            //�ֱ��¼С���ε�����
            String lt = point[0] + " " + point[3];
            String lb = point[0] + " " + point[1];
            String rt = point[2] + " " + point[3];
            String rb = point[2] + " " + point[1];
            //����о��Ƴ� û�оͼ���
            if (!set.contains(lt)) {
                set.add(lt);
            } else {
                set.remove(lt);
            }
            if (!set.contains(lb)) {
                set.add(lb);
            } else {
                set.remove(lb);
            }
            if (!set.contains(rt)) {
                set.add(rt);
            } else {
                set.remove(rt);
            }
            if (!set.contains(rb)) {
                set.add(rb);
            } else {
                set.remove(rb);
            }
        }
        //����set��ֻʣ�ĸ�����ε�����
        return set.size() == 4 && set.contains(left + " " + top) && set.contains(left + " " + down) && set.contains(right + " " + down) && set.contains(right + " " + top) && area == (right-left)*(top-down);
    }
}