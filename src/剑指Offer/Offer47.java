package 剑指Offer;

import java.util.Arrays;

public class Offer47 {
    int[][] dir = {{1,0},{0,1}};
    int[][] memo;
    public int maxValue(int[][] grid) {
        if (grid.length==0 || grid[0].length==0){
            return 0;
        }
        memo = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            Arrays.fill(memo[i],0);
        }
        return dfs(grid,0,0,0,grid.length,grid[0].length);
    }
    public int dfs(int[][] grid,int cur,int x,int y,int height,int width){
        if (memo[x][y]!=0){
            return memo[x][y];
        }
        cur+=grid[x][y];
        if (x==height-1 && y==width-1){
            memo[x][y]=grid[x][y];
            return grid[x][y];
        }
        int max = grid[x][y];
        for (int i=0;i<dir.length;i++){
            int[] dirc = dir[i];
            int next_x = x+dirc[0];
            int next_y = y+dirc[1];
            if (next_x<width && next_y<height){
                max=Math.max(max,grid[x][y]+dfs(grid, cur, next_x, next_y, height, width));
            }
        }
        memo[x][y]=max;
        return max;
    }
}
