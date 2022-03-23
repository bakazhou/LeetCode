package 剑指Offer;

import java.util.Arrays;

public class Offer12 {
    boolean flag = false;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        if (height==0){
            return false;
        }
        int width = board[0].length;
        if (width==0){
            return false;
        }
        boolean[][] visited = new boolean[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                StringBuilder sb = new StringBuilder();
                dfs(board,word,sb,i,j,height,width,visited);
                if (flag){
                    return true;
                }
            }
        }
        return flag;
    }
    public void dfs(char[][] board, String word,StringBuilder sb,int x,int y,int height,int width,boolean[][] visited){
        if (flag || sb.length()>word.length()){
            return;
        }
        sb.append(board[x][y]);
        visited[x][y]=true;
        if (sb.length()==word.length()){
            String str = sb.toString();
            if (str.equals(word)){
                flag=true;
            }
            return;
        }
        for (int i=0;i<dir.length;i++){
            int[] d = dir[i];
            int next_x = x+d[0];
            int next_y = y+d[1];
            if (next_x>=0 && next_x<height && next_y>=0 && next_y<width && !visited[next_x][next_y]){
                System.out.println(next_x);
                System.out.println(next_y);
                System.out.println("====");
                dfs(board, word, sb, next_x, next_y, height, width,visited);
            }
        }
    }
}
