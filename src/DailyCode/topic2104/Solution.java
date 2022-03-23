package DailyCode.topic2104;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ13ÈÕ 11:38
 **/
class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i=0;i<nums.length;i++){
            int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
            for (int j=i;j<nums.length;j++){
                if (nums[j]>max){
                    max = nums[j];
                }
                if (nums[j]<min){
                    min = nums[j];
                }

                ans += max-min;
            }
        }
        return ans;
    }
}