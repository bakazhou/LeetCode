package DailyCode.topic1189;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê02ÔÂ13ÈÕ 10:40
 **/
class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        int res = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        for (int i=0;i<chars.length;i++){
            if (map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        Set<Character> keySet = map.keySet();
        for (char key : keySet){
            if (key == 'l' || key == 'o'){
                res = Math.min(res,map.get(key)/2);
                continue;
            }
            res = Math.min(res,map.get(key));
        }
        return res;
    }
}
