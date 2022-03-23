package DailyCode.topic881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
        比如排序数组：{a1, a2, a3, a4}，假设a4 + a1 <= limit, a4 + a2 <= limit。
        这时候a4最理想的应当是带走a2，而不是a1，尽量留最小的使得更容易跟a3一起走。但实际上，既然a1,a2都能跟a4一起走，
        而a4又大于a3，那么a3必定也能跟a1，a2一起走的。所以无须考虑这个层次，直接考虑最重的能否跟最轻的一起走即可。
         */
        Arrays.sort(people);
        int ans = 0;//救生艇数量
        int nums = people.length;
        int left = 0,right = nums-1;
        while (nums!=0){
           int capacity = limit;
           capacity = capacity - people[right];
           right--;
           nums--;
           if (people[left]<=capacity){
               left++;
               nums--;
           }
           ans++;
        }
        return ans;
    }
}
