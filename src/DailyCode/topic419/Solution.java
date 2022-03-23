package DailyCode.topic419;

import java.util.LinkedList;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ18ÈÕ 9:37
 **/
class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j] == 'X'){
                    res++;
                    dfs(i,j,board);
                }
            }
        }
        return res;
    }
    public void dfs(int x,int y,char[][] board){
        board[x][y] = '.';
        for (int i=0;i<dir.length;i++){
            if (x+dir[i][0]>=0 && dir[i][0]+x<board.length && y+dir[i][1]>=0 && y+dir[i][1]<board[0].length && board[x+dir[i][0]][y+dir[i][1]]=='X'){
                dfs(x+dir[i][0],y+dir[i][1],board);
            }
        }
    }
}