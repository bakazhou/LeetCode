package DailyCode.topic665;

import java.util.Arrays;

public class answer {
    public boolean checkPossibility(int[] nums) {
        int k = 1;

        System.out.println(Arrays.toString(nums));
        for(int i = 0;i<=nums.length-2;i++){
            if (nums[i]>nums[i+1]){
                if (k>0){
                    k--;
                }else {
                    return false;
                }
            }
        }

        return true;
    }
}
