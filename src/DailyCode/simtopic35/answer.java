package DailyCode.simtopic35;

public class answer {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target<nums[0]) return 0;
        if (target>nums[n-1]) return n;
        for (int i=0;i<n-1;i++){
            if (nums[i]>target) return i;
        }
        return 0;
    }
}
