package DailyCode.topic2078;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ09ÈÕ 18:49
 **/
public class Solution {
    public int maxDistance(int[] colors) {
        int distance = Integer.MIN_VALUE;
        for (int i=0;i<colors.length;i++){
            for (int j=i+1;j<colors.length;j++){
                if (colors[i] != colors[j]){
                    distance = Math.max(distance,j-i);
                }
            }
        }
        return distance;
    }
}
