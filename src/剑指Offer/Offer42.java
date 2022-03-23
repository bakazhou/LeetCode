package ½£Ö¸Offer;

import java.util.Arrays;

public class Offer42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[i],dp[i]+dp[i-1]);
        }
        return dp[n-1];
    }
}
