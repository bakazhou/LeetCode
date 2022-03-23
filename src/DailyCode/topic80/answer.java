package DailyCode.topic80;

import java.util.HashMap;

public class answer {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length,ans = 0;
        for (int i=0;i<n;i++){
            System.out.println("ans:"+ans);
            System.out.println("nums[i]"+nums[i]);
            System.out.println("=============");
            if (!map.containsKey(nums[i]) || map.get(nums[i])<2){
                if (!map.containsKey(nums[i])){
                    map.put(nums[i],1);
                }
                else if (map.get(nums[i])<2){
                    map.put(nums[i],2);
                }
                nums[ans]=nums[i];
                ans++;
            }
        }
        return ans;
    }
}
