package DailyCode.topic121;

public class answer {
    public int maxProfit(int[] prices) {
        int ans = 0,min =prices[0];

        for (int i=0;i<prices.length;i++){
            if (prices[i]<min){
                min = prices[i];
            }
            ans = Math.max(prices[i] - min,ans);
        }
        return ans;
    }
}
