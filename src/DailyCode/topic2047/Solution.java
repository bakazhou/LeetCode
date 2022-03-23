package DailyCode.topic2047;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ10ÈÕ 21:37
 **/
class Solution {
    public int countValidWords(String sentence) {
        int res = 0;
        for (String m: sentence.split(" ")) {
            if (m.length() != 0 && m.matches("^[a-z]*([a-z]-[a-z]+)?[!.,]?$")) {
                res++;
            }
        }
        return res;
    }
}