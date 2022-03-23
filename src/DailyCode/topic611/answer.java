package DailyCode.topic611;

import java.util.Arrays;

public class answer {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0,n = nums.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                //找到大于nums[i]+nums[j]的最大值的下标
                int low = j+1,high = n-1,k=j;
                while (low<=high){
                    int mid = (low+high)/2;
                    if (nums[i]+nums[j]>nums[mid]){//满足条件
                        low = mid+1;
                    }else {
                        high = mid-1;
                    }
                }
                ans += k-j;
            }
        }
        return ans;
    }
}
