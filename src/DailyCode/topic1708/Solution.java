package DailyCode.topic1708;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ26ÈÕ 11:07
 **/
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strings = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i=0;i<strings.length-2;i++){
            if (strings[i].equals(first) && strings[i+1].equals(second)){
                res.add(strings[i+2]);
            }
        }
        String[] ans = new String[res.size()];
        for (int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}