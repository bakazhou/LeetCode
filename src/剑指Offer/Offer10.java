package 剑指Offer;

public class Offer10 {
    public int fib(int n) {
        if (n==1 || n==0){
            return n;
        }
        int[] dp = {0,1};
        for (int i=2;i<n;i++){
            int num = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = num;
        }
        return (dp[0]+dp[1])%1000000007;
    }
}
