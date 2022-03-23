package DailyCode.topic1020;

/**
 * @author bakazhou
 * @description
 * @date 2022年02月12日 12:47
 **/
class Solution {
    public int numEnclaves(int[][] grid) {
        int res = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 1 && (i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)){
                    dfs(i,j,grid);
                }
            }
        }

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int x,int y,int[][] grid){
        grid[x][y] = 0;
        //下
        if (x+1<grid.length && grid[x+1][y]==1){
            dfs(x+1,y,grid);
        }
        //上
        if (x-1>=0 && grid[x-1][y]==1){
            dfs(x-1,y,grid);
        }
        //左
        if (y-1>=0 && grid[x][y-1]==1){
            dfs(x,y-1,grid);
        }
        //右
        if (y+1<grid[0].length && grid[x][y+1]==1){
            dfs(x,y+1,grid);
        }
    }
}