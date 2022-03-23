package DailyCode.topic2022;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ01ÈÕ 10:35
 **/
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        System.out.println(m*n);
        System.out.println(original.length);
        if (m*n != original.length){
            return new int[][]{};
        }
        for (int i=0;i<original.length;i++){
            res[i/m][i%n] = original[i];
        }
        return res;
    }
}