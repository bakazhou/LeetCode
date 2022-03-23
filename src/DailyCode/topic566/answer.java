package DailyCode.topic566;

public class answer {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int w=nums[0].length,l=nums.length;
        if (w * l != r * c) return nums;
        int[][] ans = new int[r][c];
        for (int i=0;i<w*l;i++){
            ans[i/c][i%c]=nums[i/w][i%w];
        }
        return ans;
    }
}
