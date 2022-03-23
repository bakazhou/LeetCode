package DailyCode.week;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> list = new ArrayList<>();
    public int getMinSwaps(String num, int k) {
        int n = 0;
        char[] nums = num.toCharArray();
        for (int i=0;i<k;i++){
            swap(num,nums);
        }
        System.out.println(list);
        return n;
    }
    public void swap(String num,char[] nums){
        for (int i=nums.length-1;i>0;i--){
            if (nums[i]>nums[i-1]){
                char tem = nums[i-1];
                nums[i-1]=nums[i];
                nums[i]=tem;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            builder.append(nums[i]);
        }
        list.add(builder.toString());
    }
}
