package DailyCode.topic832;

public class topic832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            for (int j=0;j<A[0].length/2;j++){
                int a = A[i][A[0].length-j];
                A[i][A[0].length-j]=A[i][j];
                A[i][j]=a;
            }
            for (int j=0;j<A[0].length;j++){
                if (A[i][j]==0){
                    A[i][j]=1;
                }else A[i][j]=0;

            }
        }
        return A;
    }
}
