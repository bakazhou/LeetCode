package 程序员面试金典;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月13日 15:05
 **/
public class topic1707 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        List<String> list = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<synonyms.length;i++){
            String synonym = synonyms[i].substring(1,synonyms[i].length()-1);
            String[] split = synonym.split(",");
            if (!map.containsKey(split[0])){
                Set<String> s = new HashSet<>();
                s.add(split[1]);
                map.put(split[0],s);
            }else {
                map.get(split[0]).add(split[1]);
            }
            if (!map.containsKey(split[1])){
                Set<String> s = new HashSet<>();
                s.add(split[0]);
                map.put(split[1],s);
            }else {
                map.get(split[1]).add(split[0]);
            }
        }
        Set<String> stringSet = map.keySet();
        for (String key : stringSet){
            Set<String> set1 = map.get(key);
            for (String key1 : set1){
                if (map.containsKey(key1)){
                    map.get(key).addAll(map.get(key1));
                }
            }
        }
        System.out.println(map);
        String[] ans = new String[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
