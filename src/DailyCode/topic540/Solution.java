package DailyCode.topic540;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê02ÔÂ14ÈÕ 11:25
 **/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        for (int i=0;i<nums.length;i=i+2){
            if (i == nums.length-1){
                return nums[nums.length-1];
            }
            if (nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return 1;
    }
}