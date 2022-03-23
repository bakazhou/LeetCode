package DailyCode.topic2103;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ13ÈÕ 11:38
 **/
class Solution {
    public int countPoints(String rings) {
        List<HashSet> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            HashSet<Character> set = new HashSet<>();
            list.add(set);
        }
        for (int i=0;i<rings.length();i=i+2){
            int index = Integer.parseInt(rings.charAt(i + 1) + "");
            list.get(index).add(rings.charAt(i));
        }
        int ans = 0;
        for (int i=0;i<10;i++){
            if (list.get(i).size()==3){
                ans++;
            }
        }
        return ans;
    }
}