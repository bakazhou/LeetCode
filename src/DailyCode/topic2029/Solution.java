package DailyCode.topic2029;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ20ÈÕ 13:15
 **/
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0,cnt1 = 0,cnt2 = 0;
        for (int i=0;i<stones.length;i++){
            stones[i] = stones[i]%3;
            if (stones[i] == 0){
                cnt0++;
            }
            if (stones[i] == 1){
                cnt1++;
            }
            if (stones[i] == 2){
                cnt2++;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;

    }
}