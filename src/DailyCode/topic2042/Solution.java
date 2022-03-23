package DailyCode.topic2042;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ16ÈÕ 12:27
 **/
class Solution {
    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int cur = Integer.MIN_VALUE;
        for (int i=0;i<s1.length;i++){
            if (Character.isDigit(s1[i].charAt(0))){
                int num = Integer.parseInt(s1[i]);
                if (cur == Integer.MIN_VALUE){
                    cur = num;
                }else {
                    if (num > cur){
                        cur = num;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}