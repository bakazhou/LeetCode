package DailyCode.topic2033;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ17ÈÕ 10:05
 **/
class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int mid = list.get(list.size()/2),res = 0;
        for (int i=0;i<list.size();i++){
            int ope = helper(mid,list.get(i),x);
            if (ope == -1){
                return ope;
            }
            res += ope;
        }
        return res;
    }
    public int helper(int num,int cur,int x){
        if (cur == num){
            return 0;
        }
        int dif = Math.abs(cur - num);
        return dif%x==0?dif/x:-1;
    }
}