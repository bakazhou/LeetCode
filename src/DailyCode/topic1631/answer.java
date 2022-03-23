package DailyCode.topic1631;

import java.util.*;

public class answer {
    public int minimumEffortPath(int[][] heights) {
        int length = heights.length;
        int weight = heights[0].length;
        int right = 99999999,left = 0;//代表的是最小体力消耗
        int [][]dis = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};//上下左右四个方向
        while (left<right){
            int mid = (right+left)/2;
            boolean [][] flag = new boolean[length][weight];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});
            flag[0][0]=true;
            while (!queue.isEmpty()){
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                for (int i=0;i<4;i++){
                    int mx=dis[i][0]+x;
                    int my=dis[i][1]+y;
                    if (mx>=0 && my>=0 && mx<length && my<weight && (Math.abs(heights[mx][my]-heights[x][y])<=mid) && !flag[mx][my]){ //进行上下左右以及差值是否小于mid
                        flag[mx][my]=true;
                        queue.offer(new int[]{mx,my});
                    }
                }
            }
            System.out.println(mid);
            if (flag[length-1][weight-1]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
    public int minimumEffortPath1(int[][] heights) {
        /*
        超时
         */
        int length = heights.length;
        int weight = heights[0].length;
        int [][]dis = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};//上下左右四个方向
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<length;i++){
            for (int j=0;j<weight;j++){

                if (j+1<weight){
                    int d = Math.abs(heights[i][j+1]-heights[i][j]);//下
                    if(!set.contains(d)){
                        set.add(d);
                    }
                }
                if (i+1<length){
                    int r = Math.abs(heights[i+1][j]-heights[i][j]);//右
                    if(!set.contains(r)){
                        set.add(r);
                    }
                }
                if(i-1>=0){
                    int l = Math.abs(heights[i-1][j]-heights[i][j]);//左
                    if(!set.contains(l)){
                        set.add(l);
                    }
                }
            }
        }
        Vector<Integer> vector = new Vector<Integer>();
        for (Integer high:
                set    ) {
            vector.add(high);
        }
        Collections.sort(vector);
        for (int k=0;k<vector.size();k++){
            boolean [][] flag = new boolean[length][weight];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});
            flag[0][0]=true;
            while (!queue.isEmpty()){
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                for (int i=0;i<4;i++){
                    int mx=dis[i][0]+x;
                    int my=dis[i][1]+y;
                    if (mx>=0 && my>=0 && mx<length && my<weight && (Math.abs(heights[mx][my]-heights[x][y])<=vector.get(k)) && !flag[mx][my]){ //进行上下左右以及差值是否小于mid
                        flag[mx][my]=true;
                        queue.offer(new int[]{mx,my});
                    }
                }
            }
            if (flag[length-1][weight-1]){
                return vector.get(k);
            }
        }
        return 0;
    }

}


