package DailyCode.topic2106;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月13日 11:38
 **/
class Solution {
    int step = Integer.MIN_VALUE;
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] n = new int[20001];
        int ans = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        //左边界和右边界
        int left = fruits[0][0],right = fruits[fruits.length-1][0];
        for (int i=0;i<fruits.length;i++){
            map.put(fruits[i][0],fruits[i][1]);
        }
        if (map.containsKey(0)){
            n[0] = map.get(0);
        }
        for (int i=1;i<n.length;i++){
            n[i] = n[i-1];
            if (map.containsKey(i)){
                n[i] += map.get(i);
            }
        }
        //向左走i步
        for (int i=0;i<k;i++){
            if (startPos-i<0){
                break;
            }

        }
        //向右走i步
        for (int i=0;i<k;i++){
            if (startPos+i>20000){
                break;
            }
        }
        return ans;
    }

}