package DailyCode.topic26;

public class answer {
    public int removeDuplicates(int[] nums) {
        if (nums.length<=1) return nums.length;
        int left=0,right=0,times=0;
        while (right<nums.length){
            if (nums[left]==nums[right]) right++;
            else {
                left++;
                times++;
                nums[left]=nums[right];
            }
        }
        return times;
    }
}
