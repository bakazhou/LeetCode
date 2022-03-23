package DailyCode.topic2038;

/**
 * @author bakazhou
 * @description
 * @date 2022年03月22日 11:01
 **/
class Solution {
    public boolean winnerOfGame(String colors) {
        final char[] chars = colors.toCharArray();
        int n = colors.length(),low = 0,high = 0;
        int Alice = 0,Bob = 0;
        while (high<n){
            if (chars[low] != chars[high]){
                if (high - low >= 3){
                    if (chars[low] == 'A'){
                        Alice += high - low - 2;
                    }else {
                        Bob += high - low - 2;
                    }
                }
                low = high;
            }
            high++;
        }
        //处理high == n
        if (high - low >= 3){
            if (chars[low] == 'A'){
                Alice += high - low - 2;
            }else {
                Bob += high - low - 2;
            }
        }
        System.out.println(Alice);
        System.out.println(Bob);
        return Alice > Bob;
    }
}
