package DailyCode.topic368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class answer {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i=nums.length-1;i>=0;i--){
            List<Integer> list = new ArrayList<>();
            int pre = nums[i];
            for (int j=i-1;j>=0;j--){
                if ((pre%nums[j]==0 || nums[j]%pre ==0) && nums[i]%nums[j]==0){
                    list.add(nums[j]);
                    pre=nums[j];
                }
            }
            list.add(nums[i]);
            System.out.println(list);
            if (list.size()>ans.size()) ans=new ArrayList<>(list);
        }
        return ans;
    }
}
