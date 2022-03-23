package DailyCode.topic73;

import java.util.ArrayList;
import java.util.List;

public class answer {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> lie = new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (matrix[i][j]==0){
                    rows.add(i);
                    lie.add(j);
                }
            }
        }
        for (int i=0;i<rows.size();i++){
            int row = rows.get(i);
            for (int j=0;j<m;j++){
                matrix[row][j]=0;
            }
        }
        for (int i=0;i<lie.size();i++){
            int l = lie.get(i);
            for (int j=0;j<n;j++){
                matrix[j][l]=0;
            }
        }
    }
}
