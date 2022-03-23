package DailyCode.topic326;

public class Solution {
    public boolean isPowerOfThree(int n) {
        int nums = 1;
        while(nums<=n){
            nums = nums * 3;
            if (nums == n){
                return true;
            }
        }
        return false;
    }
}
