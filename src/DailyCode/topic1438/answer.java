package DailyCode.topic1438;

import java.util.*;

public class answer {
    public int longestSubarray(int[] nums, int limit) {
        List<Integer> num = new LinkedList();
        List<Integer> dif= new LinkedList();
        num.add(nums[0]);
        dif.add(nums[0]);
        int ans=1,right=0,left=0,n=nums.length;
        right++;
        while (right<n){
            while (Math.abs(dif.get(dif.size()-1)-dif.get(0))<=limit && right<n){
                num.add(nums[right]);
                dif.add(nums[right]);
                if (nums[right]<dif.get(0) || nums[right]>dif.get(dif.size()-1)){
                    Collections.sort(dif);
                }
                if (Math.abs(dif.get(dif.size()-1)-dif.get(0))<=limit){
                    ans=Math.max(ans,num.size());
                }
                right++;
            }
            num.remove(0);
            dif.remove(dif.get(dif.indexOf(nums[left])));
            left++;
        }
        return ans;
    }
}
