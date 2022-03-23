package DailyCode.topic1480;

public class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0]=nums[0];
        for (int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        return pre;
    }
}
