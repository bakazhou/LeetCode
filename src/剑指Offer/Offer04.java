package 剑指Offer;

public class Offer04 {
    boolean flag = false;
    boolean[][] visted;
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int height = matrix.length;
        if (height==0){
            return false;
        }
        int width = matrix[0].length;
        if (width==0){
            return false;
        }
        visted = new boolean[height][width];
        dfs(matrix,0,0,target,height,width);
        return flag;
    }
    public void dfs(int[][] matrix,int x,int y,int target,int height,int width){
        if (matrix[x][y]>target || flag ||visted[x][y]){
            return;
        }
        visted[x][y]=true;
        if (matrix[x][y]==target){
            flag = true;
            return;
        }
        if (x+1<height){
            dfs(matrix, x+1, y, target, height, width);
        }
        if (y+1<width){
            dfs(matrix, x, y+1, target, height, width);
        }
    }
}
