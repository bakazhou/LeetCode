package DailyCode.topic391;

import java.util.HashSet;
import java.util.Set;

/*
（1）最左下 最左上 最右下 最右上 的四个点只出现一次 其他点成对出现 （2）四个点围城的矩形面积 = 小矩形的面积之和
 */
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        //小矩形的面积和
        int area = 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(int i=0;i<rectangles.length;i++){
            //四个点全部找出来
            //rectangles[i] = [xi, yi, ai, bi]
            int[] point = rectangles[i];
            left = Math.min(left, point[0]);
            down = Math.min(down, point[1]);
            right = Math.max(right, point[2]);
            top = Math.max(top, point[3]);
            //计算小矩形面积和
            area += (point[2]-point[0])*(point[3]-point[1]);

            //分别记录小矩形的坐标
            String lt = point[0] + " " + point[3];
            String lb = point[0] + " " + point[1];
            String rt = point[2] + " " + point[3];
            String rb = point[2] + " " + point[1];
            //如果有就移除 没有就加入
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
        //最终set内只剩四个大矩形的坐标
        return set.size() == 4 && set.contains(left + " " + top) && set.contains(left + " " + down) && set.contains(right + " " + down) && set.contains(right + " " + top) && area == (right-left)*(top-down);
    }
}