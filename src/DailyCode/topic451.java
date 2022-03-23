package DailyCode;

import java.util.*;

public class topic451 {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map =new HashMap<>();
        for (int i=0;i<chars.length;i++){
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o1)>map.get(o2)){
                    return -1;
                }
                else if (map.get(o1)==map.get(o2)){
                    return 0;
                }
                return -1;
            }
        });
        for (int i=0;i<list.size();i++){
            char c = list.get(i);
            int n = map.get(c);
            for (int j=0;j<n;j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
