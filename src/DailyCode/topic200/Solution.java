package DailyCode.topic200;

public class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length,m = grid[0].length;
        for (int i =0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]=='1'){//此处为1
                    ans++;
                    //进行感染
                    helper(i,j,grid);
                }
            }
        }
        return ans;
    }

    public void helper(int x,int y,char[][] grid){
        grid[x][y] = '2';
        if (y-1>=0 && grid[x][y-1]=='1'){
            helper(x,y-1,grid);
        }
        if (y+1<grid[0].length && grid[x][y+1]=='1'){
            helper(x,y+1,grid);
        }
        if (x+1<grid.length && grid[x+1][y]=='1'){
            helper(x+1,y,grid);
        }
        if (x-1>=0 && grid[x-1][y]=='1'){
            helper(x-1,y,grid);
        }
    }
}
