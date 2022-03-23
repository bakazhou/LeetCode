package DailyCode.topic1743;

import java.lang.reflect.Array;
import java.util.*;

public class answer {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int[] ans = new int[n];
        for (int i=0;i<n;i++){
            int[] a = adjacentPairs[i];
            Arrays.sort(a);
            map.put(a[0],a[1]);
            if (a[0]<min){
                min=a[0];
            }
            if (a[1]<min){
                min=a[1];
            }
        }
        int index = 0;
        while (!map.containsKey(min)){
            ans[index]=min;
            index++;
            min=map.get(min);
        }
        ans[index]=min;
        return ans;
    }
}
