package DailyCode.topic611;

import java.util.Arrays;

public class answer {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0,n = nums.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                //�ҵ�����nums[i]+nums[j]�����ֵ���±�
                int low = j+1,high = n-1,k=j;
                while (low<=high){
                    int mid = (low+high)/2;
                    if (nums[i]+nums[j]>nums[mid]){//��������
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
