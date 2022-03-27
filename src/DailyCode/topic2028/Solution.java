package DailyCode.topic2028;

/**
 * @author bakazhou
 **/
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumTimes = rolls.length + n;
        int sumScore = sumTimes * mean;
        int mScore = 0;
        for (int roll : rolls) {
            mScore += roll;
        }
        int nScore = sumScore - mScore;
        if (nScore < n || nScore > 6 * n) {
            return new int[0];
        }
        int avr = nScore / n;
        int sub = nScore % n;
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = avr;
            if (sub != 0){
                res[i]++;
                sub--;
            }
        }
        return res;
    }
}
