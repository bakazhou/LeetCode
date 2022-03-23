package DailyCode.topic519;

import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[][] nums;
    public Solution(int m, int n) {
        nums = new int[m][n];
    }

    public int[] flip() {
        Random random = new Random();
        while (true){
            int x = random.nextInt(nums.length);
            int y = random.nextInt(nums[0].length);
            if (nums[x][y]==0){
                nums[x][y]=1;
                return new int[]{x,y};
            }
        }
    }

    public void reset() {
        for (int i=0;i<nums.length;i++){
            Arrays.fill(nums[i],0);
        }
    }
}