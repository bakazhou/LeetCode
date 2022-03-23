package DailyCode.topic643;

public class answer {
    public double findMaxAverage(int[] nums, int k) {
        /*
        经典滑动窗口
        左指针和右指针不断向右移动，达到求出所有子数组的目的
        再进行/k就得到了平均数
        因为double的计算比int慢 所以只在最终求结果时将sum转成double类型
         */
        double ans = -9999999;
        int left = 0,right = 0;
        int sum = 0;
        for (int i=0;i<k;i++){
            sum+=nums[right];
            right++;
        }
        ans=Math.max((double)sum/k,ans);
        while(right<nums.length){
            sum-=nums[left];
            left++;
            sum+=nums[right];
            right++;
            ans=Math.max((double)sum/k,ans);
        }
        return ans;
    }
}
