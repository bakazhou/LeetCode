package DailyCode.topic448;

import java.util.*;

public class answer {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for (int i=1;i<=n;i++){
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;

    }
}
