package DailyCode.topic506;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ02ÈÕ 10:30
 **/
class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans =  new String[score.length];
        int[] c = score.clone();
        Arrays.sort(c);
        int[] clone = new int[c.length];
        for (int i=c.length-1,j=0;i>=0;i--,j++){
            clone[j] = c[i];
        }
        Map<Integer,String> map = new HashMap<>();
        for (int i=0;i<clone.length;i++){
            if (i==0){
                map.put(clone[i],"Gold Medal");
            }
            else if (i==1){
                map.put(clone[i],"Silver Medal");
            }
            else if (i==2){
                map.put(clone[i],"Bronze Medal");
            }
            else{
                map.put(clone[i],Integer.toString(clone[i]));
            }
        }
        for (int i=0;i<score.length;i++){
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}