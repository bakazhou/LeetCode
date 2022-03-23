package 剑指Offer;

import java.util.*;

public class Offer50 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<chars.length;i++){
            if (set.contains(chars[i])){
                list.add(chars[i]);
                set.add(chars[i]);
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        for (int i=0;i<list.size();i++){
            if (map.get(list.get(i))==1){
                return list.get(i);
            }
        }
        return 1;
    }
}
