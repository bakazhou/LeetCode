package DailyCode.topic1518;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��17�� 9:51
 **/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0,emptyBottles = 0;
        while (numBottles != 0){
            //�ȵ���curƿ��
            ans += numBottles;
            //��ƿ������
            emptyBottles += numBottles;
            int ex = emptyBottles/numExchange;
            //���ƺ�ʣ�µĿվ�ƿ
            emptyBottles %= numExchange;
            numBottles += ex;
        }
        return ans;
    }
}