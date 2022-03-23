package DailyCode.topic1518;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月17日 9:51
 **/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0,emptyBottles = 0;
        while (numBottles != 0){
            //喝掉了cur瓶酒
            ans += numBottles;
            //空瓶子数量
            emptyBottles += numBottles;
            int ex = emptyBottles/numExchange;
            //换酒后剩下的空酒瓶
            emptyBottles %= numExchange;
            numBottles += ex;
        }
        return ans;
    }
}