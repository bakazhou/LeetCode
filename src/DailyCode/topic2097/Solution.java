package DailyCode.topic2097;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ07ÈÕ 14:50
 **/
public class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[0]){
                    return 1;
                }
                return -1;
            }
        });
        return pairs;
    }
}
