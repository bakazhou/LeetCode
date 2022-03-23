package DailyCode.topic2090;

import java.util.Arrays;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ08ÈÕ 18:14
 **/
class Solution {
    public int[] getAverages(int[] nums, int k) {
        System.out.println(nums.length);
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        if (k > nums.length){
            return ans;
        }
        int x = 2*k+1;
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i];
        }
        for (int i=k;i<nums.length-k;i++){
            if (i-k<0 || i+k>nums.length-1){
                ans[i] = -1;
            }else {
                if (i-k == 0){
                    ans[i] = (int) (preSum[i+k] / x);
                }else {
                    ans[i] = (int) ((preSum[i+k]-preSum[i-k-1]) / x);
                }
            }
        }
        return ans;
    }
}