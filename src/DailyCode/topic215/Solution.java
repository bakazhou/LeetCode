package DailyCode.topic215;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ07ÈÕ 13:31
 **/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
        }
        System.out.println(queue);
        return 1;
    }
}
