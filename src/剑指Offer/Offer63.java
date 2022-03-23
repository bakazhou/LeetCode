package 剑指Offer;

public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int dp[] = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<min){
                min=prices[i];
            }
            dp[i] = Math.max(dp[i-1],prices[i]-min);
        }
        return dp[prices.length-1];
    }
}
