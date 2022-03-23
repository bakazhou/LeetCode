package DailyCode.topic220;

import java.util.*;

public class answer {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /*
        给你一个整数数组 nums 和两个整数 k 和 t 。
        请你判断是否存在两个下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，
        同时又满足 abs(i - j) <= k 。
         */
        TreeSet<Long> set = new TreeSet<>();
        int left = 0,right = k,n=nums.length;
        if (k>=n) return false;
        if (k<0 || t<0) return false;
        for (int i=0;i<k;i++){
            set.add((long)nums[i]);
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
        }
        //[1,5,9,1,5,9], k = 2, t = 3
        while (right<n){
            set.add((long)nums[right]);
            right++;
//            Long ceiling = set.ceiling((long) nums[i] - (long) t);
//            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
//                return true;
//            }
            set.remove((long)nums[left]);
            left++;
        }
        return false;
    }
}
