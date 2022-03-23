package DailyCode.topic198;

import java.util.Arrays;

public class answer {
    int[] note;
    public int rob(int[] nums) {
        //备忘录记录结果
        note = new int[nums.length];
        Arrays.fill(note,-1);
        return dfs(nums,0);
    }
    public int dfs(int[] nums,int index){
        if (note[index]!=-1) return note[index];
        if (index>=nums.length){
            return 0;
        }
        int money=Math.max(
                //不抢，去下一家抢
                dfs(nums,index+1),
                //抢了去下下家
                nums[index]+dfs(nums,index+2));
        note[index] = money;
        return money;
    }


    public int rob1(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        if (n==0) return 0;
        if (n==2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
