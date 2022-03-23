package DailyCode.topic441;

import java.util.Arrays;

public class Solution {
    public static String solve (int[] nums) {
        // write code here
        String[] strings = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strings[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        return "";
    }

    public static void main(String[] args) {
        int[] a = {2,20,23,4,8};
        System.out.println(solve(a));
    }
}
