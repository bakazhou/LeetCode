package DailyCode.topic1446;

import java.util.Map;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ01ÈÕ 10:03
 **/
class Solution {
    public int maxPower(String s) {
        int ans = Integer.MIN_VALUE,low = 0,high = 0;
        char[] chars = s.toCharArray();
        while (high< chars.length){
            int leng = 0;
            while (high< chars.length && chars[low] == chars[high]){
                leng++;
                high++;
            }
            low = high;
            ans = Math.max(ans,leng);
        }
        return ans;
    }
}