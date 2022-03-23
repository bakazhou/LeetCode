package DailyCode.topic1716;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ20ÈÕ 14:44
 **/
class Solution {
    public int totalMoney(int n) {
        int times = n/7;
        int days = n%7,res = 0,cur = 1;
        for (int i=0;i<times;i++){
            res += 7*(cur+cur+7)/2;
            cur ++;
        }
        res += days*(cur+cur+days)/2;
        return res;
    }
}