package DailyCode.topic322;

import java.util.Arrays;

class Solution {
    public int coinChange1(int[] coins, int amount) {
        if (amount<0) return -1;//递归的终止条件，说明兑换的方式不能够换出amount
        if (amount==0) return 0;

        int ans = Integer.MAX_VALUE,length=coins.length;
        for (int i=0;i<length;i++){
            int semple = coinChange1(coins,amount-coins[i]);
            if (semple==-1) continue;
            ans = Math.min(ans,semple+1);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    int[] note;
    public int coinChange2(int[] coins, int amount) {
        note = new int[amount+1];
        Arrays.fill(note,-999);
        return search(coins,amount);
    }
    public int search(int[] coins,int amount){
        if (amount<0) return -1;//递归的终止条件，说明兑换的方式不能够换出amount
        if (amount==0) return 0;
        if (note[amount]!=-999) return note[amount];
        int length = coins.length,res=Integer.MAX_VALUE;
        for (int i=0;i<length;i++){
            int semple = search(coins,amount-coins[i]);
            if (semple==-1) continue;
            res=Math.min(res,semple+1);
        }
        note[amount]=res==Integer.MAX_VALUE?-1:res;
        return note[amount];
    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        if (amount==0) return 0;
        if (amount<0) return -1;
        dp[0]=0;
        for (int i=0;i<amount+1;i++){
            for (int coin:coins){
                if (i-coin<0) continue;
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}