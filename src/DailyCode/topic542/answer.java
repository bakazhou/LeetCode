package DailyCode.topic542;

public class answer {
    public int[][] updateMatrix(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            boolean[][] visted = new boolean[matrix.length][matrix[0].length];
            for (int j=0;j<matrix[0].length;j++){
                matrix[i][j] = bfs(i,j,matrix,0,visted);
            }
        }
        return matrix;
    }
    public int bfs(int x,int y,int[][] matrix,int dict,boolean[][] visted){
        visted[x][y]=true;
        if (matrix[x][y]==0){
            return dict;
        }
        int a=0,b=0,c=0,d=0;
        if (x-1>=0 && !visted[x-1][y]){//上方
            a=bfs(x-1,y,matrix,dict+1,visted);
        }
        if (x+1<matrix.length && !visted[x+1][y]){//下方
            b=bfs(x+1,y,matrix,dict+1,visted);
        }
        if (y-1>=0 && !visted[x][y-1]){
            c=bfs(x,y-1,matrix,dict+1,visted);
        }
        if (y+1<matrix[0].length && !visted[x][y+1]){
            d=bfs(x,y+1,matrix,dict+1,visted);
        }
        return Math.min(Math.min(a,b),Math.min(c,d));
    }
}
