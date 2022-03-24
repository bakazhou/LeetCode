package DailyCode.topic661;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê03ÔÂ24ÈÕ 21:07
 **/
class Solution {
    int[][] dir = {{1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1},{0,0}};
    public int[][] imageSmoother(int[][] img) {
        int n = img.length,m = img[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = floor(i,j,img,n,m);
            }
        }
        return result;
    }
    public int floor(int x,int y,int[][] img,int n,int m){
        int sum = 0,times = 0;
        for (int[] ints : dir) {
            if (x+ints[0]>=0 && y+ints[1]>=0 && x+ints[0]<n && y+ints[1]<m){
                sum += img[x+ints[0]][y+ints[1]];
                times++;
            }
        }
        return sum/times;
    }
}