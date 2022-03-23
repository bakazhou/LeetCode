package 剑指Offer2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Offer014 {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        if (n2<n1){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        for (int i=0;i<n1;i++){
            if (!map1.containsKey(s1.charAt(i))){
                map1.put(s1.charAt(i),1);
            }else {
                map1.put(s1.charAt(i),map1.get(s1.charAt(i))+1);
            }
        }
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i=0;i<n1;i++){
            if (!map2.containsKey(s2.charAt(i))){
                map2.put(s2.charAt(i),1);
            }else {
                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
            }
        }
        int low = 0,high = n1;
        if (check(map1,map2)){
            return true;
        }
        while (high<n2){
            //添加high处的新字符
            if (!map2.containsKey(s2.charAt(high))){
                map2.put(s2.charAt(high),1);
            }else {
                map2.put(s2.charAt(high),map2.get(s2.charAt(high))+1);
            }
            //删除low处字符
            int num = map2.get(s2.charAt(low));
            if (num>1){
                map2.put(s2.charAt(low),num-1);
            }else {
                map2.remove(s2.charAt(low));
            }
            if (check(map1,map2)){
                return true;
            }
            high++;
            low++;
        }
        return false;
    }
    public boolean check(Map<Character,Integer> map1,Map<Character,Integer> map2){
        Set<Character> set = map1.keySet();
        for (Character key : set){
            if (!map2.containsKey(key)){
                return  false;
            }else {
                if (!map1.get(key).equals(map2.get(key))){
                    return false;
                }
            }
        }
        return true;
    }
}
