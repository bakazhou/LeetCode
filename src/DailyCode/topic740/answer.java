package DailyCode.topic740;

import java.util.*;

public class answer {
    /*
    Map<Integer,Integer> map;
    List<Integer> list;
    int sum = 0;
    public int deleteAndEarn(int[] nums) {
        map = new HashMap<>();
        list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i])) {
                list.add(nums[i]);
                map.put(nums[i],1);
            }else map.put(nums[i],map.get(nums[i])+1);
        }
        return sum;
    }
    public void dfs(int cur){
        if (map.isEmpty()){
            if (cur>sum){
                sum=cur;
                return;
            }
        }
    }
    */

    public int DeleteAndEarn(int[] nums) {
            if (nums.length==0) return 0;
            if (nums.length==1) return nums[0];
            int num[] = new int[nums.length+1];
            Map<Integer,Integer> map = new HashMap<>();
            for (int i=0;i<nums.length;i++){
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i],1);
                }else map.put(nums[i],map.get(nums[i])+1);
            }
            Set<Integer> set = map.keySet();
            for (Integer index:set) {
                num[index] = index*map.get(index);
            }

            int[] dp = new int[nums.length+1];
            dp[1]=num[1];
            dp[2]=Math.max(num[1],num[2]);
            for (int i=3;i<num.length;i++){
                dp[i]=Math.max(dp[i-2]+num[i],dp[i-1]);
            }
            return dp[num.length-1];
    }
}
