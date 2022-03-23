package DailyCode.topic213;

public class answer {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];
        for (int i=0;i<nums.length-1;i++){
            dp1[i]=nums[i];
        }
        for (int i=1;i<nums.length;i++){
            dp2[i]=nums[i];
        }
        return Math.max(dp(dp1),dp(dp2));
    }
    public int dp(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];//只有一间房屋
        if (n==0) return 0;//没有房屋
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[0],nums[1]);//两间房里偷钱更多的那一间
        for (int i=2;i<nums.length;i++){//从第三间房开始
            dp[i]=Math.max(
                    dp[i-2]+nums[i]//偷着此处的钱
                    ,dp[i-1]);//不偷此处的钱偷的是上一间房间的钱
        }
        return dp[nums.length-1];
    }
}
