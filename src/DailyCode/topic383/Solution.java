package DailyCode.topic383;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ04ÈÕ 15:00
 **/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] maga = magazine.toCharArray();
        for (int i=0;i<maga.length;i++){
            if (!map.containsKey(maga[i])){
                map.put(maga[i],1);
            }else {
                map.put(maga[i],map.get(maga[i])+1);
            }
        }
        char[] ransom = ransomNote.toCharArray();
        for (int i=0;i<ransom.length;i++){
            if (!map.containsKey(ransom[i])){
                return false;
            }else {
                int num = map.get(ransom[i]);
                if (num==1){
                    map.remove(ransom[i]);
                }else {
                    map.put(ransom[i],num-1);
                }
            }
        }
        return true;
    }
}
