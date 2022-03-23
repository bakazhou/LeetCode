package DailyCode.topic598;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length==0){
            return m*n;
        }
        int minM=Integer.MAX_VALUE,minN=Integer.MIN_VALUE;
        for (int i=0;i<ops.length;i++){
            if (ops[i][0]<minM){
                minM = ops[i][0];
            }
            if (ops[i][1]<minN){
                minN = ops[i][1];
            }
        }
        return minM*minN;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{3,2},{3,3},{2,2}};
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]<o2[0]){
                    return -1;
                }
                if (o1[1]<o2[1]){
                    return -1;
                }
                return 1;
            }
        });
        for (int i=0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}