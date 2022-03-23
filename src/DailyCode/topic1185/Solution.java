package DailyCode.topic1185;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ03ÈÕ 20:38
 **/
public class Solution {
    public String dayOfTheWeek(int d, int m, int y) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if(m < 3) {
            m += 12;
            --y;
        }
        int D = y + y/4 - y/100 + y/400 + 2*m + 3*(m+1)/5 + d + 1;
        return weeks[D%7];
    }
}
