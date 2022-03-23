package DailyCode.topic1137;

public class answer {
    public int tribonacci(int n) {
        int[] dp = {0,1,1};
        if (n<=2){
            return n==0?0:1;
        }
        int ans = 0;
        for (int i=3;i<=n;i++){
            ans = dp[0]+dp[1]+dp[2];
            dp[0]=dp[1];
            dp[1]=dp[2];
            dp[2]=ans;
        }
        return ans;
    }
}
