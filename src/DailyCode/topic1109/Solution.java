package DailyCode.topic1109;

import java.util.Arrays;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] air:bookings){
            ans[air[0]-1]+=air[2];
            ans[air[1]]-=air[2];
        }
        System.out.println(Arrays.toString(ans));
        for (int i=1;i<n;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}
