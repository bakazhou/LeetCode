package DailyCode.topic27;

public class answer {
    public int removeElement(int[] nums, int val) {
        int left=0,right=0;
        for (int i=0;i<nums.length;i++){
            if (nums[right]!=val){
                nums[left]=nums[right];
                left++;
                right++;
            }else {
                right++;
            }
        }
        return left;
    }
}
