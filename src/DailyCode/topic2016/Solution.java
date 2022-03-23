package DailyCode.topic2016;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê02ÔÂ26ÈÕ 12:05
 **/
class Solution {
    public int maximumDifference(int[] nums) {
        int low = 0,high = 0,res = Integer.MIN_VALUE;
        while (high<nums.length){
            if (nums[high] >= nums[low]){
                res = Math.max(res,nums[high]-nums[low]);
                high++;
            }else {
                low=high;
            }
        }
        return res==0?-1:res;
    }
}