package DailyCode.topic778;

import java.util.LinkedList;
import java.util.Queue;

public class answer {
    public int swimInWater(int[][] grid) {
        /*
        二分查找加上bfs,直到所找到的值既为最小也能到达右下角为止
         */
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int weight = grid.length;
        int length = grid[0].length;
        int left=Math.max(grid[0][0],grid[weight-1][length-1]),right=2500,mid=0;
        while (left<right){
            Queue<int[]> queue =new LinkedList<>();
            mid=(left+right)/2;
            boolean[][] flag = new boolean[weight][length];
            flag[0][0]=true;
            queue.offer(new int[]{0,0});
            while (!queue.isEmpty()){
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                for (int i=0;i<4;i++){
                    int[] dirc = dir[i];
                    int mx = dirc[0]+x;
                    int my = dirc[1]+y;
                    if (mx>=0 && my>=0 && mx<length && my<weight && !flag[mx][my] && (mid>=grid[mx][my])){
                        queue.offer(new int[]{mx,my});
                        flag[mx][my]=true;//标记
                    }
                }
            }
            if (flag[weight-1][length-1]){//右下角被访问到
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
