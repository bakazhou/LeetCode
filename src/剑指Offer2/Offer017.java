package 剑指Offer2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Offer017 {
    public String minWindow(String s,String t) {
        Map<Character,Integer> mapT = new HashMap<>();
        Map<Character,Integer> mapS = new HashMap<>();
        int n1 = s.length(),n2 = t.length(),low = 0,high = 0;
        int ansLow = 0,ansHigh = n1+1;
        for (int i=0;i<n2;i++){
            if (!mapT.containsKey(t.charAt(i))){
                mapT.put(t.charAt(i),1);
            }else {
                mapT.put(t.charAt(i),mapT.get(t.charAt(i))+1);
            }
        }
        while (high<n1){
            while (high<n1 &&!judge(mapT,mapS)){//找到从low开始的最小覆盖子串
                if (!mapS.containsKey(s.charAt(high))){
                    mapS.put(s.charAt(high),1);
                }else {
                    mapS.put(s.charAt(high),mapS.get(s.charAt(high))+1);
                }
                high++;
            }
            while (low<high && judge(mapT,mapS)){//从low开始删除字符,直到不符合最小覆盖
                if (high-low < ansHigh-ansLow){//有更小的子串
                    ansHigh = high;
                    ansLow = low;
                }
                mapS.put(s.charAt(low), mapS.get(s.charAt(low))-1);
                low++;
            }

        }
        return ansHigh-ansLow==n1+1?"":s.substring(ansLow,ansHigh);
    }
    //需要优化
    public boolean judge(Map<Character,Integer> map1,Map<Character,Integer> map2){
        Set<Character> set = map1.keySet();
        for (Character key:set){
            if (!map2.containsKey(key)){
                return false;
            }
            if (map1.get(key)>map2.get(key)){
                return false;
            }
        }
        return true;
    }
}
