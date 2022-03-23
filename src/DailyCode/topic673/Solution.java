package DailyCode.topic673;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = Integer.MIN_VALUE;
        LinkedList<Integer> num = new LinkedList<>();
        int right = 0;
        while (right<nums.length){
            if (num.isEmpty()){//numÎª¿Õ
                num.add(nums[right]);
                right++;
            }
            else {
                if (nums[right]>num.get(num.size()-1)){
                    num.add(nums[right]);
                }
                else if (nums[right]<num.get(num.size()-1)){
                    while (!num.isEmpty() && nums[right]<=num.get(num.size()-1)) {
                        num.removeLast();
                    }
                    num.add(nums[right]);
                }
                right++;
            }
            length = Math.max(length,num.size());
        }
        return length;
    }
}
