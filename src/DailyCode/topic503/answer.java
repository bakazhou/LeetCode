package DailyCode.topic503;

import java.util.Arrays;

public class answer {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n+n-1];
        int[] ans = new int[n];
        for (int i = 0;i < n;i++){
            temp[i] = nums[i];
        }
        for (int i=n,j=0;i<2*n-1;i++,j++){
            temp[i]=nums[j];
        }
        Arrays.fill(ans,-1);
        int m = temp.length;
        for (int i = 0;i < n;i++){
            int max = -1;
            for (int j = i;j<m;j++){
                if (temp[j]>nums[i]){
                    max = temp[j];
                    break;
                }
            }
            ans[i]=max;

        }
        return ans;
    }
}
