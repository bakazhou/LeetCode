package DailyCode.topic64;

public class answer {
    int ans=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        bfs(grid,0,0,0);
        return ans;
    }
    public void bfs(int[][] grid,int x,int y,int road){//不会走回头路~
        road+=grid[x][y];
        if (x==grid.length-1 && y==grid[0].length-1){
            if (road<ans) ans=road;
            return;
        }
        if (x+1<=grid.length-1) bfs(grid, x+1, y, road);
        if (y+1<=grid[0].length-1) bfs(grid, x+1, y, road);
    }
}
