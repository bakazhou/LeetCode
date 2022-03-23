package 暴力递归.硬币问题;

public class Solution {
    //money为一个硬币组合,target为需要凑出来的钱,moneyCount返回有多少种凑法,每种硬币的数量是无限的,找出使用零钱最少的凑法
    public int moneyDfsCount(int[] money,int target){
        return ans;
    }
    public int ans = Integer.MAX_VALUE;
    //暴力递归
    //cur是当前需要凑出的钱
    public void dfs(int[] money,int cur,int step){
        if (cur == 0){
            ans = Math.min(step,ans);
            return;
        }
        if (cur < 0){//无法凑出
            return;
        }
        for (int i=0;i<money.length;i++){
            dfs(money, cur-money[i], step+1);
        }
    }

}
