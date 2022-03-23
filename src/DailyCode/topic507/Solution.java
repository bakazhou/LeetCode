package DailyCode.topic507;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ31ÈÕ 12:47
 **/
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1){
            return false;
        }
        int res = 1;
            for (int i=2;i<Math.sqrt(num);i++){
            if (num % i == 0){
                res = res + i + (num/i);
            }
            System.out.println(res);
        }
        return res == num;
    }
}
