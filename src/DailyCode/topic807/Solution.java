package DailyCode.topic807;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月13日 10:32
 **/
class Solution {
    /*
每一个位置的建筑物从四个角度看都不能超过最高的那个建筑物，比如第一排的建筑物为 { 3， 0， 8， 7}，
这一排最高的建筑物的高度是8，那么每一列的建筑物不能超过这一排的建筑物，对应的，每一个位置的建筑物不能超过它所在的那一列和那一行，
然后要得出所有建筑物能增加到最大值的总和
    */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //行
        List<Integer> row = new ArrayList<>();
        //列
        List<Integer> column = new ArrayList<>();
        for (int i=0;i<grid.length;i++){
            int max = Integer.MIN_VALUE;
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            row.add(max);
        }
        for (int i=0;i<grid[0].length;i++){
            int max = Integer.MIN_VALUE;
            for (int j=0;j<grid.length;j++){
                if (grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            column.add(max);
        }
        System.out.println(row);
        System.out.println(column);
        int ans = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int max = Math.min(row.get(i),column.get(j));
                if (grid[i][j] < max){
                    ans += max-grid[i][j];
                }
            }
        }
        return ans;
    }
}