package DailyCode.topic396;

/**
 * @author bakazhou
 **/
class Solution {
    //F(k)=F(k?1)+numSum?n¡Ánums[n?k]
    public int maxRotateFunction(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int numSum = 0,f = 0;
        for (int i = 0; i < n; i++) {
            numSum += nums[i];
            f += i*nums[i];
        }
        int max = f;
        for (int i = 1; i < n; i++) {
            f = f + numSum - n * nums[n - i];
            max = Math.max(max,f);
        }
        return max;
    }

}
