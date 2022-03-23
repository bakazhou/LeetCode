package DailyCode.topic581;

import java.util.Arrays;

public class answer {
    public int findUnsortedSubarray(int[] nums) {
        int[] tem = nums.clone();
        Arrays.sort(tem);
        int begin=0,end=0,n=nums.length;
        for (int i=0;i<n;i++){
            if (nums[i]!=tem[i]){
                begin=i;
                break;
            }
        }
        for (int i=n-1;i>=0;i--){
            if (nums[i]!=tem[i]){
                end=i;
                break;
            }
        }
        if (begin==0 || end==0){
            return 0;
        }
        return end-begin;
    }
}
