package DailyCode.topic74;

public class answer {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length,m = matrix.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
